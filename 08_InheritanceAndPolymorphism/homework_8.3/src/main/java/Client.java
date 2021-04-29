public abstract class Client {


    private double bankAccount;

    public double getAmount() {
        return bankAccount;
    }

    public boolean put(double amountToPut) {
        if (amountToPut > 0) {
            bankAccount += amountToPut;
            System.out.println("Счет по полнен! Баланс счета - " + getAmount() + "рублей.");
            System.out.println("Баланс счета - " + getAmount() + "рублей.");
            return true;
        } else {
            System.out.println("Пополнить счет не удалось. Сумма пополнения не может быть отрицательной!");
            System.out.println("Баланс счета - " + getAmount() + "рублей.");
            return false;
        }

    }

    public boolean take(double amountToTake) {

        if (amountToTake != 0 && amountToTake > 0 && amountToTake <= bankAccount) {
            bankAccount -= amountToTake;
            System.out.println("Сумма списана в размере - " + amountToTake + "рублей");
            System.out.println("Баланс счета - " + getAmount() + "рублей");
            return true;
        } else {
            System.out.println("Сумма перевода не должна быть отрицательной или превышающей сумму на счету.");
            System.out.println("Баланс счета - " + getAmount() + "рублей");
            return false;
        }

    }

    public abstract void bankСonditions();


}