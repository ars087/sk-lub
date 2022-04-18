
import java.time.LocalDate;

public class DepositAccount extends BankAccount {

    private LocalDate lastIncome;
    public static final long NUMBER_OF_MONTHS = 1;

   public void put(double amountToPut) {
        lastIncome = LocalDate.now();
        // lastIncome = LocalDate.of(2021, 3, 24);
        super.put(amountToPut);

    }

    @Override
    public boolean take(double amountToTake) {

        if (lastIncome == null && getAmount() == 0) {
            System.out.println("Пополните счет. Отсутствуют средства.");
            return false;
        }

        LocalDate allowTakeDate = lastIncome.plusMonths(NUMBER_OF_MONTHS);
        LocalDate now = LocalDate.now();

        if (now.isAfter(allowTakeDate)) {
            super.take(amountToTake);
            return true;
        } else {
            System.out.println("С момента последнего пополнения не прошёл 1 месяц.");//

            return false;
        }

    }
}




