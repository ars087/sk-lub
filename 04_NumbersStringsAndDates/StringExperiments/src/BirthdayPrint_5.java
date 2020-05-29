import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
class BirthdayPrint_5 {

    public static void main(String[] args) throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");

        Calendar birthday = Calendar.getInstance();
        birthday.setLenient(false);
        String input = new Scanner(System.in).nextLine();

        try {
            birthday.setTime(dateFormat.parse(input));

        } catch ( ParseException e) {

            System.out.println("вы ввели неверный формат даты! правильный формат - 21.12.1990");
            e.getMessage();
            return;
        }

        printAllBirthday(birthday);
    }

    public static void printAllBirthday(Calendar birthday)  {
        DateFormat dateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy");
        Calendar today = Calendar.getInstance();
        // birthday.setLenient(false);// почему то не работает??
        System.out.println(dateFormat.format(birthday.getTime()));

        while ( today.after(birthday)) {

            birthday.roll(Calendar.YEAR, 1);

            if (today.after(birthday)) {
                System.out.println(dateFormat.format(birthday.getTime()));
            }

        }
    }
}