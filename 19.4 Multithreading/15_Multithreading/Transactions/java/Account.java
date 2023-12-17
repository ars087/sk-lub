public class Account {


    private volatile boolean isFraudResult = false;


    private  long blockingTime = 0;

    private  long   moneyBalance;

    private String firstName;
    private String lastName;
    private String accNumber;
    public Account(String firstName, String lastName, String accNumber, long bankLoan) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.accNumber = accNumber;
        this.moneyBalance = bankLoan;

    }



    public long getMyBalance() {
        return moneyBalance;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isFraudResult() {
        return isFraudResult;
    }

    public void setFraudResult(boolean fraudResult) {
        isFraudResult = fraudResult;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }


    public void addBalance(long sum) {

        moneyBalance += sum;
        System.out.println("Баланс пополнен -: " + sum);
    }

    public void withdrawalBalance(long sum) {

        if (moneyBalance != 0 && moneyBalance >= sum) {
            moneyBalance -= sum;
            System.out.println(" Перевод успешно выполнен " + sum);

        }
    }

     public  boolean unlocking( long blockingTime){

      if (  blockingTime >=  this.blockingTime + 1000    ){

          isFraudResult = false;

      }

     return isFraudResult;
     }


    public long getBlockingTime() {
        return blockingTime;
    }

    public void setBlockingTime(long blockingTime) {
        this.blockingTime = blockingTime;
    }

}