public class IndividualBusinessman extends Client {
    public static final double MAXIMUM_COMMISSION = 0.01;
    public static final double MINIMUM_COMMISSION = 0.005;
    public static final double MINIMUM_AMOUNT = 1000;

    @Override
    public boolean put(double amountToPut) {

        if (amountToPut < MINIMUM_AMOUNT) {

            double commissionFromReplenishment = amountToPut * MAXIMUM_COMMISSION;
            double commissionWithAmount = amountToPut - commissionFromReplenishment;
            super.put(commissionWithAmount);
            System.out.println("Комиссия пополнения составила" + commissionFromReplenishment + "рублей");
            return true;
        } else if (amountToPut >= MINIMUM_AMOUNT) {

            double commissionFromReplenishment = amountToPut * MINIMUM_COMMISSION;
            double commissionWithAmount = amountToPut - commissionFromReplenishment;
            super.put(commissionWithAmount);
            System.out.println("Комиссия пополнения составила" + commissionFromReplenishment + "рублей");
            return true;


        }
        return false;
    }

    @Override
    public void bankСonditions() {

        System.out.println("Счет индивидуального предпринимаателя.\n" +
                "Комиссия за пополнение составляет 1% от суммы, если сумма пополнения меньше 1000рублей и\n" +
                "0,5% от суммы пополнения равной 1000рублей и более.\n" +
                "Списание средств cо счета индивидуального предпринимателя осуществляется без комиссии.");
        getAmount();

    }

}

