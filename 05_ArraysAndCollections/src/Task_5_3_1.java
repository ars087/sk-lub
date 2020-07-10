import java.util.Scanner;
import java.util.TreeSet;

public class Task_5_3_1 {

  public static final String REG_EMAIL = "\\b([\\dA-Za-z[_][-][!#$%&'*+/=?^_`{|}~]]([\\.])?)+\\b@\\b([\\da-z]([-])?)+\\b\\.[A-Za-z]+";
  private static final String REG_ADD = "^ADD\\s+" + REG_EMAIL + "$";
  private static final String REG_LIST = "LIST\\s*+";
  private static final String REG_CLEAR = "CLEAR\\s*+";

  private static TreeSet<String> list = new TreeSet();

  public static void main(String[] args) {
    for (; ; ) {
      System.out.println("Добавьте E-mail в список. Пример : ADD hello@skillbox.ru");
      String input = new Scanner(System.in).nextLine();
      if (input.matches(REG_ADD)) {
        addE_mail(todoSplit(input));
      } else if (input.matches(REG_LIST)) {
        listPrint();
      } else if (input.matches(REG_CLEAR)) {
        clear();
      }
    }
  }

  private static void addE_mail(String add) {
    list.add(add);
    System.out.println("E-mail добавлен в список");
    size();
  }

  private static void size() {
    if (list.size() > 0) {
      System.out.println("Количество E-mail в списке :" + list.size());
    } else {
      System.out.println("Список пуст!");
    }
  }

  private static String todoSplit(String add) {
    String todoText = "";
    if (add.matches(REG_ADD)) {
      String[] addArray = add.split("\\s+", 2);
      todoText = (String) addArray[1];
    }
    return todoText;
  }

  private static void listPrint() {
    size();
    for (String list : list) {
      System.out.println(list);
    }
  }

  private static void clear() {
    list.clear();
    System.out.println("Список очищен");
    size();
  }
}