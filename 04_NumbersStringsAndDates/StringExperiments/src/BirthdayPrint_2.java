import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class BirthdayPrint_2 {

    public static void main(String[] args) throws InterruptedException {

        DateFormat dateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy");
        //SimpleDateFormat dateFormatOne = new SimpleDateFormat("MMMM");

        Calendar dateToday = GregorianCalendar.getInstance();
        Date date12 = dateToday.getTime();

        int getYear = dateToday.get(Calendar.YEAR);/////год

        System.out.println(dateFormat.format(date12));
        int i = 0;
        for (; ; ) {
        System.out.println("Введите вашу  дату рождени  в формате год, месяц, число! Например: 1970/01/12 или 1970-01-12 или  1970 01 12 ");

        final String REG_FULLNAME = "([1]([9])|(([2])([0-9])))\\d{2}[/,\\-,\\s]([0]([1-9])|(([1])([0-2])))[/,\\-,\\s]([0-2]([1-9])|(([3])([0-1])))";

        int countPlus = 0;
        int countMinus = 0;

            Scanner scanner = new Scanner(System.in);
            String birthday = scanner.nextLine();
            GregorianCalendar calendar = new GregorianCalendar();

            boolean  cycle  = true;

            while (cycle) {

             i++;
            if (birthday.matches(REG_FULLNAME)) {

                String[] splite = birthday.split("[/,\\-,\\s]");


                int year = Integer.parseInt(splite[0]);
                int month = Integer.parseInt(splite[1]);
                int day = Integer.parseInt(splite[2]);



                year = year - countMinus + countPlus;
                month = month - (1);


                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DATE, day);

                DateFormat dateFormatt = new SimpleDateFormat("EEEE, d MMMM yyyy");
                Date doday = calendar.getTime();


                boolean isLeapYear = calendar.isLeapYear(year);


                if (month == Calendar.FEBRUARY && day == 29) {

                    if (isLeapYear && getYear > year) {
                        countPlus += 3;
                        System.out.println(i + ")" + dateFormatt.format(doday));

                    } else if (isLeapYear && getYear < year) {

                        countMinus -= -3;

                        System.out.println(i + ")" + dateFormatt.format(doday));
                    }

                    if (isLeapYear && getYear == year) {

                        System.out.println(i + ")" + dateFormatt.format(doday));
                        break;
                    }

                    if (!isLeapYear) {

                        System.out.println("Введена не верная дата рождения!!! Не високосный год!!");
                           break;

                    }

                } else {
                    System.out.println(i + ")" + dateFormatt.format(doday));
                }

                if (getYear == year) {

                    cycle = false;

                } else if (year < getYear) {

                    countPlus += 1;

                }
                if (year > getYear) {
                    countMinus -= -1;

                }

            } else {
                System.out.println(" вы ввели не верный формат даты рождения");
               break;
            }

          }

        }

    }

}

