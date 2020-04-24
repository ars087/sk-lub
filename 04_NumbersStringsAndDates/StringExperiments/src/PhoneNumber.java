
import java.util.Scanner;

  public class PhoneNumber {


        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            System.out.println(" Напишите вашу Фамилию, Имя, Отчество!");

            int rightLong;
            boolean numberOne = false ;

            String phoneNumber;

            while ( !numberOne ){
                phoneNumber   = scanner.nextLine();

                String countText = phoneNumber.replaceAll("[A-Z a-z.!@'|><`~^%#&?/,()*+\\-]","");

                char firstNumber = countText.charAt(0);
                rightLong = countText.length();

                if (rightLong == 11 && firstNumber == '7' || firstNumber == '8' ){

                    System.out.println("Номер введен верно!");
                    System.out.println(countText);

                    numberOne =true;

                }else {
                    System.out.println(countText.length());
                    System.out.println("Номер телефона введен с ошибкой!!Количество цифр не должно быть больше 11 или меньше 11");
                    System.out.println("Если вы из России первая цифра вашего телефонного номера должна начинаться с цифры 7, либо 8");

                }
            }
        }
    }

