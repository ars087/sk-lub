import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_5_4_1 {

  public static final HashMap<String, String> list = new HashMap<String, String>();

  public static Scanner scanner = new Scanner(System.in);

  public static final String REG_LIST = "LIST\\s*+";
  public static final String REG_PHONE = "^[7|8]\\d{10}";
  public static final String REG_NAME = "[А-Яа-я]+";
  public static final String REG_NAME_PHONE = "^[7|8]\\d{10}|[А-Яа-я]+";//"; //^[7|8]\\d{10}";

  public static String name = "";
  public static String phoneNumber = "";
  public static String input = "";

  public static void main(String[] args) {

    System.out.println("Введите имя или телефонный номер");
    for (; ; ) {
      if (name.length() > 0 && phoneNumber.length() > 0) {
        list.put(phoneNumber, name);
        System.out.println("Запись добавлена");
        name = "";
        phoneNumber = "";
      }
      input = scanner.nextLine();
      comparison(input);
      add(input);
      addPhoneNumber(input);
      printPhoneBook(input);
      size();
    }
  }

  public static void printPhoneBook(String phone) {
    if (phone.matches(REG_LIST)) {
      System.out.println("Длина листа" + list.size());
      for (String key : list.keySet()) {
        System.out.println(list.get(key) + "||" + key);
      }
      System.out.println(list.size());
    }
  }

  public static void add(String add) {
    if (add.matches(REG_NAME)) {
      name = add;
      System.out.println("Имя добавлено");
    }
  }

  public static void addPhoneNumber(String addPhoneNumder) {
    if (addPhoneNumder.matches(REG_PHONE)) {
      phoneNumber = addPhoneNumder;
      System.out.println("Номер добавлен");
    }
  }

  public static String comparison(String addPhone) {
    if (addPhone.matches(REG_NAME_PHONE)) {
      if (list.containsKey(addPhone)) {
        System.out.println(list.get(addPhone) + " " + addPhone);
        System.out.println("Данный  номер телефона уже существует! Измените запись");
        input = "";
      } else if (list.containsValue(addPhone)) {
        for (Map.Entry entry : list.entrySet()) {
          if (addPhone.equals(entry.getValue())) {
            System.out.println(entry.getValue() + " " + entry.getKey());
          }
        }
        System.out.println("Данное имя уже существует!Измените запись");
        input = "";
      }
    }
    return input;
  }

  public static void size() {
    if (list.size() > 0) {
      System.out.println("Записей в телефонной книге" + list.size());
    }
  }
}