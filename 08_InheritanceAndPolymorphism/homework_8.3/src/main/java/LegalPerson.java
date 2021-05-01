
public class LegalPerson extends Client {
    public static final double COMMISSION = 0.01;


    @Override
    public boolean take(double amountToTake) {
        double commission = amountToTake * COMMISSION;
        double amountWithCommission = commission + amountToTake;
        if (super.take(amountWithCommission)) {
            System.out.println("  Комиссия составила - " + commission + "рублей");

            return true;
        }

        return false;
    }

    @Override
    public void conditions() {
        System.out.println("Счет юридического лица.\n" +
                "Комиссия за пополнение отсутствует.\n " +
                "Размер комиссии  составляет 1% от суммы списания.");
        getAmount();

    }
}
