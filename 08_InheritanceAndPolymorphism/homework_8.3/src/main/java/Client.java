public abstract class Client {


    private double bankAccount;

    public double getAmount() {
        System.out.println("Баланс счета - " + bankAccount + "рублей.");
        return bankAccount;
    }

    public boolean put(double amountToPut) {
        if (amountToPut > 0) {
            bankAccount += amountToPut;
            System.out.println("Счет по полнен!");
        getAmount();
            return true;
        } else {
            System.out.println("Пополнить счет не удалось. Сумма пополнения не может быть отрицательной!");
            getAmount();
            return false;
        }

    }

    public boolean take(double amountToTake) {

        if (amountToTake != 0 && amountToTake > 0 && amountToTake <= bankAccount) {
            bankAccount -= amountToTake;
            System.out.println("Сумма списана в размере - " + amountToTake + "рублей");
            getAmount();
            return true;
        } else {
            System.out.println("Сумма перевода не должна быть отрицательной или превышающей сумму на счету.");
           getAmount();
            return false;
        }

    }

    public abstract void conditions();


}