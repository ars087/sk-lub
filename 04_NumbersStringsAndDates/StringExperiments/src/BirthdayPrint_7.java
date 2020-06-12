import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
class test_6 {

    public static void main(String[] args) throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        dateFormat.setLenient(false);
        Calendar birthday = Calendar.getInstance();
        for (; ;) {
            String input = new Scanner(System.in).nextLine();

            try {
                birthday.setTime(dateFormat.parse(input));

            } catch (ParseException e) {

                System.out.println("вы ввели неверный формат даты! правильный формат - 1990.12.21");
                e.getMessage();
                return;
            }

            printAllBirthday(birthday);
        }
    }
    public static void printAllBirthday(Calendar birthdayOne)  {
        DateFormat dateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy");
        Calendar today = Calendar.getInstance();

        System.out.println(dateFormat.format(birthdayOne.getTime()));

        while ( today.after(birthdayOne)) {

            if( birthdayOne.get(Calendar.MONTH ) == Calendar.FEBRUARY && birthdayOne.get(Calendar.DATE) == 29) {

                birthdayOne.roll(Calendar.YEAR, 4);

                if (today.after(birthdayOne)) {
                    System.out.println(dateFormat.format(birthdayOne.getTime()));
                }

            } else {

                birthdayOne.roll(Calendar.YEAR, 1);

                if (today.after(birthdayOne)) {
                    System.out.println(dateFormat.format(birthdayOne.getTime()));
                }
            }
        }
    }
}