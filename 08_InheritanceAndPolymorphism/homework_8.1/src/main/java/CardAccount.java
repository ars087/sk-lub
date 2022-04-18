public class CardAccount extends BankAccount {
    public static final double COMMISSION = 0.01;

    @Override
  public boolean take(double amountToTake) {

        double commission = amountToTake * COMMISSION;
        double amountWithCommission = commission + amountToTake;
        if (super.take(amountWithCommission)) {
            System.out.println("Комиссия за перевод составила :" + commission + "р.");
            return true;
        }

        return false;//////
    }

}
