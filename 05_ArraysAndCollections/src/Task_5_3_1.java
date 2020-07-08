import java.util.Scanner;
import java.util.TreeSet;

public class Task_5_3_1 {

  public static final String REG_EMAIL = "\\b([\\dA-Za-z[_][-][!#$%&'*+/=?^_`{|}~]]([\\.])?)+\\b@\\b([\\da-z]([-])?)+\\b\\.[A-Za-z]+";
  private static final String REG_ADD = "^ADD\\s+" + REG_EMAIL + "$";
  private static final String REG_LIST = "LIST";
  private static final String REG_CLEAR = "CLEAR\\s*+";

  private static TreeSet<String> list = new TreeSet();

  public static void main(String[] args) {
    for (; ; ) {
      String input = new Scanner(System.in).nextLine();
    /*  String[] addArray = input.split("\\s+", 2);
      if (addArray.length > 1) {
        String todoText = addArray[1];
        addE_mail(todoText);
      }*/
      addE_mail(todoSplit(input));
      listPrint(input);
      clear(input);

      if (list.size() > 0) {
        System.out.println("Количество E-mail в списке :" + list.size());
      } else {
        System.out.println("Список пуст");
      }
    }
  }

  private static void addE_mail(String add) {
    if (add.matches(REG_EMAIL)) {
      list.add(add);
      System.out.println("E-mail добавлен в список");
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

  private static void listPrint(String listInput) {
    if (listInput.matches(REG_LIST)) {
      for (String list : list) {
        System.out.println(list);
      }
    }
  }

  private static void clear(String clear) {
    if (clear.matches(REG_CLEAR)) {
      if (list.size() > 0) {
        list.clear();
        System.out.println("Список очищен");
      }
    }
  }
}
