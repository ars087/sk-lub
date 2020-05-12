import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class BirthdayPrint {

    public static void main(String[] args) throws InterruptedException {


        DateFormat dateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy");
        SimpleDateFormat dateFormatOne = new SimpleDateFormat("MMMM");

        Calendar dateToday = GregorianCalendar.getInstance();
        Date date12 = dateToday.getTime();

        int getYear = dateToday.get(Calendar.YEAR);/////год

        System.out.println(dateFormat.format(date12));
        System.out.println("Введите вашу  дату рождени  в формате год, месяц, число! Например: 1970/01/12");

        boolean  cycle  = true;

        Scanner scanner = new Scanner(System.in);
        String birthday  = scanner.nextLine();
        int countPlus = 0;
        int countMinus = 0;
        int i =0;

        while ( cycle ){
            i+=1;
            String countText = birthday.replaceAll("[/.,\\-]", "");

            GregorianCalendar calendar = new GregorianCalendar();

            int length = countText.length();
            if (length == 8) {

                char numberOneYear = countText.charAt(0);
                String stringNumberOneYear = Character.toString(numberOneYear);
                char numberTwoYear = countText.charAt(1);
                String stringNumberTwoYear = Character.toString(numberTwoYear);
                char numberThreeYear = countText.charAt(2);
                String stringNumberThreeYear = Character.toString(numberThreeYear);
                char numberFourYear = countText.charAt(3);
                String stringNumberFourYear = Character.toString(numberFourYear);

                boolean isNumberOneYear = numberOneYear >= '1' && numberOneYear <= '3' && Character.isDigit(numberOneYear);//год
                boolean isNumberTwoYear = numberTwoYear == '9' || numberOneYear == '2' && numberTwoYear == '0' && Character.isDigit(numberTwoYear);//год
                boolean isNumberThreeYear = Character.isDigit(numberThreeYear);//год
                boolean isNumberFourYear = Character.isDigit(numberFourYear);//год

//////////////////////////////////////////////////////////////--Месяц---////////////////////////////////////////////////////////
                char numberOneMonth = countText.charAt(4);
                String stringNumberOneMonth = Character.toString(numberOneMonth);
                char numberTwoMonth = countText.charAt(5);
                String stringNumberTwoMonth = Character.toString(numberTwoMonth);

                boolean isNumberOneMonth = numberOneMonth <= '1' && Character.isDigit(numberOneMonth);
                boolean isNumberTwoMonth =   numberOneMonth == '1' &&  numberTwoMonth <= '2' ||numberOneMonth == '0' && numberTwoMonth <= '9' && Character.isDigit(numberTwoMonth) ;
                ////////////////////////////////////////---День---/////////////////////////////////////////////////////////////////

                char numberOneDay = countText.charAt(6);

                char numberTwoDay = countText.charAt(7);


                boolean isNumberOneDay = numberOneDay <= '3' && Character.isDigit(numberOneDay);
                boolean isNumberTwoDay =  numberOneDay == '3' && numberTwoDay <= '1'|| numberOneDay <='2'&& numberTwoDay <='9' && Character.isDigit(numberTwoDay);


                if (isNumberOneYear && isNumberTwoYear && isNumberThreeYear && isNumberFourYear && isNumberOneMonth && isNumberTwoMonth && isNumberOneDay && isNumberTwoDay) {
                    String stringYear = stringNumberOneYear + stringNumberTwoYear + stringNumberThreeYear + stringNumberFourYear;//год
                    String stringMonth = stringNumberOneMonth + stringNumberTwoMonth;//месяц
                    String stringDay = numberOneDay + Character.toString(numberTwoDay);//день


                    int year   = Integer.parseInt(stringYear) - countMinus + countPlus ;
                    int  month  =  Integer.parseInt(stringMonth)-(1);
                    int  day =Integer.parseInt(stringDay);



                    calendar.set(Calendar.YEAR, year);
                    calendar.set(Calendar.MONTH, month);
                    calendar.set(Calendar.DATE, day);

                    DateFormat dateFormatt = new SimpleDateFormat("EEEE, d MMMM yyyy");
                    Date doday = calendar.getTime();




                    boolean isLeapYear  =  calendar.isLeapYear(year);


                    if ( month == Calendar.FEBRUARY && day == 29  ) {

                        if ( isLeapYear && getYear > year ){
                            countPlus += 3;
                            System.out.println( i + ")"+dateFormatt.format(doday));

                        }else   if ( isLeapYear &&  getYear < year )  {

                            countMinus -= -3;

                            System.out.println( i +")"+dateFormatt.format(doday));
                        }

                        if ( isLeapYear &&  getYear == year )  {

                            System.out.println( i + ")" +dateFormatt.format(doday) );
                            break;
                        }

                        if(!isLeapYear) {

                            System.out.println("Введена не верная дата рождения!!! Не високосный год"+ isLeapYear);

                            birthday  = scanner.nextLine();
                            i=0;
                            continue;
                        }
                        int dfg = 14/4;
                    } else { System.out.println(i + ")" + dateFormatt.format(doday)  ); }


                    if ( getYear == year ) {


                        cycle = false;


                    }else if (year < getYear)  {

                        countPlus += 1;

                    }
                    if ( year > getYear ){
                        countMinus -= -1;

                    }

                } else {
                    System.out.println(" вы ввели не верный  год рождения.");
                    birthday  = scanner.nextLine();
                    i=0;
                }

            } else if (length > 8) {

                System.out.println("Дата введена в не верном фомате!Вы указали лишнии цифры в дате рождения!");
                birthday  = scanner.nextLine();
                i=0;

            } else {
                System.out.println("Дата введена в не верном фомате!Вы ввели не полную дату!");

                birthday  = scanner.nextLine();
                i=0;
            }
        }
    }
}





