public class BankAccount {

    private double invoice = 0;

    protected double getAmount() {
        return invoice;
    }

    protected void put(double amountToPut) {

        if (amountToPut > 0) {
            invoice += amountToPut;
            System.out.println("Счет пополнен на сумму :" + amountToPut + "р.");
            System.out.println("Баланс счета :" + getAmount() + "р.");
        } else {
            System.out.println("Пополнить счет не удалось. Сумма пополнения не может быть отрицательной!");

        }
    }

    protected boolean take(double amountToTake) {

        if (amountToTake != 0 && amountToTake > 0 && amountToTake <= invoice) {
            invoice -= amountToTake;
            System.out.println("Сумма списана в размере :" + amountToTake + "р.");
            System.out.println("Баланс счета :" + getAmount() + "р.");
            return true;
        } else {
            System.out.println("Сумма перевода не должна быть отрицательной или превышающей сумму на счету.");

            return false;
        }
    }

    protected boolean send(BankAccount receiver, double amount) {

        if (take(amount)) {
            receiver.put(amount);
            System.out.println("Перевод между счетами успешно завершен.");
            return true;
        }
        return false;
    }
}
