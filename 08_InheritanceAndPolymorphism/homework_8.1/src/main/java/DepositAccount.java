
import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome;

    public void put(double amountToPut) {

        if (amountToPut < 0) {
            System.out.println("Пополнить счет  не удалось. Сумма пополнения не может быть отрицательной!");
        } else if (lastIncome == null) {
            lastIncome = LocalDate.now();
            invoice += amountToPut;
            System.out.println("Счет пополнен на сумму :" + amountToPut);
        } else {
            LocalDate localDate = lastIncome.plusMonths(1);
            LocalDate localDate1 = LocalDate.now();
            if (localDate1.isAfter(localDate)) {
                invoice += amountToPut;
                System.out.println("Баланс пополнен.");
                lastIncome = localDate1;

            } else {
                System.out.println("С момента последнего пополнения не прошёл 1 месяц.");
            }

        }
    }
}




