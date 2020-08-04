import java.util.Scanner;
import java.util.TreeSet;

public class Task_5_3_1 {

    public static final String REG_EMAIL = "\\b([\\dA-Za-z[_][-][!#$%&'*+/=?^_`{|}~]]([\\.])?)+\\b@\\b([\\da-z]([-])?)+\\b\\.[A-Za-z]+";
    private static final String REG_ADD = "^ADD\\s+" + REG_EMAIL + "$";
    private static final String REG_LIST = "LIST\\s*+";
    private static final String REG_CLEAR = "CLEAR\\s*+";

    private static TreeSet<String> emails = new TreeSet();

    public static void main(String[] args) {
        for (; ; ) {
            System.out.println("Добавьте E-mail в список. Пример : ADD hello@skillbox.ru");
            String input = new Scanner(System.in).nextLine();
            if (input.matches(REG_ADD)) {
                addEmail(todoSplit(input));
            } else if (input.matches(REG_LIST)) {
                emailPrint();
            } else if (input.matches(REG_CLEAR)) {
                clear();
            }
        }
    }


    private static void addEmail(String email) {
        emails.add(email);
        System.out.println("E-mail добавлен в список");
        printEmailsSize();
    }

    private static void printEmailsSize() {
        if (emails.size() > 0) {
            System.out.println("Количество E-mail в списке :" + emails.size());
        } else {
            System.out.println("Список пуст!");
        }
    }

    private static String todoSplit(String input) {
        String todoText = "";
        if (input.matches(REG_ADD)) {
            String[] array = input.split("\\s+", 2);
            todoText = (String) array[1];
        }
        return todoText;
    }

    private static void emailPrint() {
        printEmailsSize();
        for (String list : emails) {
            System.out.println(list);
        }
    }

    private static void clear() {
        emails.clear();
        System.out.println("Список очищен");
        printEmailsSize();
    }
}