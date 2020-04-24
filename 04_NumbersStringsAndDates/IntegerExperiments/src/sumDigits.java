import java.util.Scanner;

public class sumDigits {

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            System.out.println("Введите число");
            String string = scan.nextLine();

            int count = 0;

            char index;

            for(int i = 0; i < string.length(); i++) {

                index = string.charAt(i);

                int  intNumber = Integer.parseInt(String.valueOf(index));


                count += intNumber ;

            }

            System.out.println(count);
        }
    }

