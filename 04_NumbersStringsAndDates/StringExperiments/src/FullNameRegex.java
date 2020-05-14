import java.util.Scanner;

public class FullNameRegex {

    public static void main(String[] args) {
        final String REG_FULLNAME = "[А-Яа-я]{2,11}\\s+[А-Яа-я]{2,11}\\s+[А-Яа-я]{2,11}\\s{0,10}"; // в этой строке впишите регулярку

        Scanner scanner = new Scanner(System.in);
        System.out.println("Напишите вашу Фамилию, Имя, Отчество!");
        String fullName = scanner.nextLine();
        while (true) {

            if (fullName.matches(REG_FULLNAME)) {

                String [] text = fullName.split("\\s+");
                          for ( String typingWords : text ) {

                              System.out.println(typingWords);
                          }
                // выполняете split и печатайте строки ФИО
                break;
            } else {
                System.out.println("Неверный формат строки, попробуйте еще раз");
                fullName = scanner.nextLine();

            }
        }

            }
        }




