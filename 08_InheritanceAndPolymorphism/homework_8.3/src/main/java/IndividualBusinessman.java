public class IndividualBusinessman extends Client {
    public static final double MAXIMUM_COMMISSION = 0.01;
    public static final double MINIMUM_COMMISSION = 0.005;
    public static final double MINIMUM_AMOUNT = 1000;

    @Override
    public boolean put(double amountToPut) {

        double commissionForReplenishment;

        if (amountToPut < MINIMUM_AMOUNT) {

            commissionForReplenishment = amountToPut * MAXIMUM_COMMISSION;
            amountToPut = amountToPut - commissionForReplenishment;
           if( super.put(amountToPut)) {
               System.out.println("Комиссия пополнения составила" + commissionForReplenishment + "рублей");
               return true;
           }
           return false;
        } else if (amountToPut >= MINIMUM_AMOUNT) {

            commissionForReplenishment = amountToPut * MINIMUM_COMMISSION;
            amountToPut = amountToPut - commissionForReplenishment;
            super.put(amountToPut);
            System.out.println("Комиссия пополнения составила" + commissionForReplenishment + "рублей");
            return true;

        }
        return false;
    }

    @Override
    public void conditions() {

        System.out.println("Счет индивидуального предпринимаателя.\n" +
                "Комиссия за пополнение составляет 1% от суммы, если сумма пополнения меньше 1000рублей и\n" +
                "0,5% от суммы пополнения равной 1000рублей и более.\n" +
                "Списание средств cо счета индивидуального предпринимателя осуществляется без комиссии.");
        getAmount();

    }

}

