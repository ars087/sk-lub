public class CardAccount extends BankAccount {

    public boolean take(double amountToTake) {

        boolean successfully;

        if (amountToTake > invoice) {
            System.out.println("На счету недостаточно средств.Измените значение суммы списания");
            successfully = false;

        } else if (amountToTake < 0) {
            System.out.println("Сумма не должна быть отрицательной");
            successfully = false;

        } else {
            double paymentCommission = amountToTake * 0.01;
            invoice -= amountToTake + paymentCommission;
            System.out.println("Средства списаны!Комиссия составила" + paymentCommission);
            successfully = true;
        }

        return successfully;
    }
}
