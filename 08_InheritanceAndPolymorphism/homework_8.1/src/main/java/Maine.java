
public class Maine {

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();
        bankAccount.put(1);
        bankAccount.put(10);

        DepositAccount depositAccount = new DepositAccount();
        depositAccount.put(5);
        depositAccount.take(1);

        CardAccount cardAccount = new CardAccount();
        depositAccount.send(cardAccount,2);

         // cardAccount.put(1);
        //cardAccount.send(depositAccount, 10);


    }
}
