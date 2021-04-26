
import java.time.LocalDate;

public class DepositAccount extends BankAccount {

    private LocalDate lastIncome;

    public void put(double amountToPut) {
        lastIncome = LocalDate.now();
        // lastIncome = LocalDate.of(2021, 3, 24);
        super.put(amountToPut);
    }

    @Override
    protected boolean take(double amountToTake) {

        if (lastIncome == null && getAmount() == 0) {
            System.out.println("Пополните счет. Отсутствуют средства.");
            return false;
        }
        LocalDate localDate = lastIncome.plusMonths(1);
        LocalDate localDate1 = LocalDate.now();

        if (localDate1.isAfter(localDate)) {
            super.take(amountToTake);
            lastIncome = localDate1;
            return true;
        } else {
            System.out.println("С момента последнего пополнения не прошёл 1 месяц.");

            return false;
        }

    }
}




