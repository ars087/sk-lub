
public class Maine {

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();
        bankAccount.put(10);

        DepositAccount depositAccount = new DepositAccount();
        bankAccount.send(depositAccount, 10);

        System.out.println(bankAccount.getAmount());
        System.out.println(depositAccount.getAmount());

        depositAccount.put(12);

    }
}
