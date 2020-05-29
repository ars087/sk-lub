import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.Scanner;

    class BirthdayPrint_4 {

        public static void main(String[] args){

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy.MM.dd");
            LocalDate birthday;
            String input = new Scanner(System.in).nextLine();

            try {
                birthday = LocalDate.parse(input, dateFormat);

            } catch (DateTimeParseException e) {

                System.out.println("вы ввели неверный формат даты! правильный формат - 21.12.1990");
                e.getMessage();
                return;
            }
            printAllBirthday(birthday);

        }
        public static void printAllBirthday(LocalDate birthdayOne)  {
            LocalDate today = LocalDate.now();

            System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(birthdayOne));
            while ( today.isAfter(birthdayOne)) {

                boolean  isLeap = birthdayOne.isLeapYear();
                Month month = birthdayOne.getMonth();
                int date = birthdayOne.getDayOfMonth();

                if (   isLeap && month == Month.FEBRUARY && date == 29 ) {

                    birthdayOne = birthdayOne.plusYears(4);

                    if(today.isAfter(birthdayOne)) {
                        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(birthdayOne));

                    }
                }else {

                    birthdayOne = birthdayOne.plusYears(1);

                    if(today.isAfter(birthdayOne)) {
                        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(birthdayOne));

                    }
                }
            }
        }
    }

