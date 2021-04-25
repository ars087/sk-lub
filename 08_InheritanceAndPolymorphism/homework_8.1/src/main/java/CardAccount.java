public class CardAccount extends BankAccount {


    @Override
    protected boolean take(double amountToTake) {

        double commission = amountToTake * 0.01;
        double amountWithCommission = (amountToTake * 0.01) + amountToTake;
        if (super.take(amountWithCommission)) {
            System.out.println("Комиссия за перевод составила :" + commission + "р.");
            return true;
        }

        return false;
    }

}
