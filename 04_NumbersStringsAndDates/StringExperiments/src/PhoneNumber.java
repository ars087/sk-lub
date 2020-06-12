
import java.util.Scanner;

  public class PhoneNumber {


        public static void main(String[] args) {

            final String REG_FULLNAME = "^[7|8]\\d{10}"; // в этой строке впишите регулярку

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите ваш номер телефона!");


            String   phoneNumber   = scanner.nextLine();
            //String countText = phoneNumber.replaceAll("[\\D]","");

            boolean numberOne = false ;

        for ( ; ; ){

                if (phoneNumber.matches(REG_FULLNAME) ){

                    System.out.println("Номер введен верно");
                    phoneNumber   = scanner.nextLine();
                }
                else {
                    //System.out.println(countText.length());
                    System.out.println("Номер телефона введен с ошибкой!!Количество цифр не должно быть больше 11 или меньше 11");
                    System.out.println("Если вы из России первая цифра вашего телефонного номера должна начинаться с цифры 7, либо 8");
                    phoneNumber   = scanner.nextLine();
                }
            }
        }
    }

