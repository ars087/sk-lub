import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

    public class BirthdayPrint_3 {

        // Делаем dateFormat переменной класса,
        // чтобы не передавать ее в параметрах методов
        // то есть выносим ее снаружи методов, но внутри класса
        //  private static DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");

        public static void main(String[] args) throws ParseException {

            DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");

            Calendar birthday = Calendar.getInstance();
            birthday.setLenient(false);
            String input = new Scanner(System.in).nextLine();
            //int x = Integer.parseInt(input);
            //System.out.println(  birthday.);

            try {

                birthday.setTime(dateFormat.parse(input));

                // вызываем метод печати, передаем в него результат парсинга (birthday)
            } catch ( ParseException e) {

                System.out.println("вы ввели неверный формат даты! правильный формат - 21.12.1990");
                e.printStackTrace();
                return;

            }
            printAllBirthday(birthday);
        }

        public static void printAllBirthday(Calendar birthday)  {
            DateFormat dateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy");
            Calendar today = Calendar.getInstance();
            // birthday.setLenient(false);// почему то не работает??
            System.out.println(dateFormat.format(birthday.getTime()));


            int yearToday = today.get(Calendar.YEAR);
            int yearBirthday = birthday.get(Calendar.YEAR);

            while ( yearBirthday != yearToday ) {

                birthday.roll(Calendar.YEAR, 1);
               // birthday.add(Calendar.YEAR,1);

                yearBirthday = birthday.get(Calendar.YEAR);


                System.out.println(dateFormat.format(birthday.getTime()));

            }
        }
    }


