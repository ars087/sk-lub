import java.util.*;

public class Bank implements Runnable {


    private static    long bankMoney = 1000000;
    //  private List<String> bankBorrowers;
    public Bank bank;
   // public Account account;
    private int generateAccount = 0;


    public Bank(List<String> bankBorrowers) {

        //  this.bankBorrowers = bankBorrowers;
        addBankClientMap(bankBorrowers);



    }

    public Bank(Account account) {
        bankAccountsClient.put(account.getAccNumber(), account);

    }


    private Map<String, Account> bankAccountsClient = new HashMap<>();
    private final Random random = new Random();

    public synchronized boolean isFraud()
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }


    public void  transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {

        var fromAccountNumber = bankAccountsClient.get(fromAccountNum);
        var toAccountNumber = bankAccountsClient.get(toAccountNum);


        boolean isFraudResult = false;

        if (!fromAccountNumber.unlocking(System.currentTimeMillis())) {


            if (amount > 50000) {
                isFraudResult = isFraud();
                if (isFraudResult) {

                    fromAccountNumber.setFraudResult(isFraudResult);

                    System.out.println("Перевод заблокирован! Просьба обратиться в банк по номеру телефона +7800200500");
                     fromAccountNumber.setBlockingTime(System.currentTimeMillis());

                } else {

                         createTransfer(fromAccountNumber,toAccountNumber,amount); }
                System.out.println( fromAccountNumber.getFirstName() + " -> " + toAccountNumber.getFirstName()  );
            } else {

                createTransfer(fromAccountNumber,toAccountNumber,amount); }
            System.out.println( fromAccountNumber.getFirstName() + " -> " + toAccountNumber.getFirstName() );
        }else {
            System.out.println(" Уважаемый клиент ваш счет был заблокирован системой безопасности банка! ");
        }


    }


    @Override
    public void run() {

        try {

            for (int y = 0; y < 10; y++) {
                long transferAmount = (long) (Math.random() * 10000);
                String[] array = getArrayAccount();
                int fromAccounNum = (int) (Math.random() * array.length);
                int toAccounNum = (int) (Math.random() * array.length);
                if (fromAccounNum == toAccounNum ){
                    continue;
                }

                if (0 == y % 10) {  // 5%
                    long bigTransferAmount = (long) (50000 + Math.random() * 20000);
                    transfer( array[fromAccounNum], array[toAccounNum], bigTransferAmount);
                    continue;
                }

                transfer( array[fromAccounNum], array[toAccounNum], transferAmount);

            }


        } catch (Throwable ex) {

            System.out.println(ex.getMessage());
        }


    }
    public  String[] getArrayAccount() {

        Set<Map.Entry<String, Account>> keySet = bankAccountsClient.entrySet();
        Iterator<Map.Entry<String, Account>> iterator = keySet.iterator();
        String[] accountNumber = new String[keySet.size()];
        int i = 0;
        while (iterator.hasNext()) {
            String s = iterator.next().getKey();
            accountNumber[i] = bankAccountsClient.get(s).getAccNumber();
            i++;
        }
        return accountNumber;

    }
    private void createTransfer(Account fromAccountNumber, Account toAccountNumber, long amount) {

        int  accountFromInt = Integer.parseInt( fromAccountNumber.getAccNumber());
        int accountToIn = Integer.parseInt( toAccountNumber.getAccNumber());

        if( accountFromInt > accountToIn ){
            fromAccountNumber = toAccountNumber;
            toAccountNumber = fromAccountNumber;

        }

        synchronized (fromAccountNumber ) {

            synchronized (toAccountNumber) {
                if (fromAccountNumber.getMyBalance() >= amount) {
                    fromAccountNumber.withdrawalBalance(amount);
                    toAccountNumber.addBalance(amount);
                } else {
                    System.out.println(fromAccountNumber.getFirstName() + " Пополните  ваш счет. Средств не достаточно");

                }

            }
        }

    }


    public void addBankClientMap(List<String> bankBorrowers) {

        for (String s : bankBorrowers) {

            String[] arraySplit = s.split(" ");
            var generateAccountNumber = getGenerateAccountNumber();

            bankAccountsClient.put(generateAccountNumber, new Account(arraySplit[0], arraySplit[1], generateAccountNumber, issuingLoan()));

        }

    }

    private String getGenerateAccountNumber() {

        generateAccount++;

        return "000000000" + generateAccount;
    }

    private long issuingLoan() {

        long sum = (long) (80000 + Math.random() * 120000);

        bankMoney -= sum;
        if (bankMoney < 250000) {
            bankMoney = 1000000;

        }
        return sum;
    }


    public int getQuantityClient() {
        return bankAccountsClient.size();
    }

    public long getBalanceAccount(String accountNum) {

        return getBankAccountsClient().get(accountNum).getMyBalance();
    }




    public Map<String, Account> getBankAccountsClient() {
        return bankAccountsClient;
    }



    public long getSumAllAccounts() {


        Set<Map.Entry<String, Account>> sat = bankAccountsClient.entrySet();


        Iterator<Map.Entry<String, Account>> iterator = sat.iterator();

        long allBalanceAccount = 0;
        while (iterator.hasNext()) {

            String it = iterator.next().getKey();

            var account1 = bankAccountsClient.get(it);

            allBalanceAccount += account1.getMyBalance();
        }

        return allBalanceAccount;
    }

    public long getBankMoney() {
        return bankMoney;
    }


}
