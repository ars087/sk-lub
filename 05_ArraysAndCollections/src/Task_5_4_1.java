import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_5_4_1 {

  public static final HashMap<String, String> list = new HashMap<String, String>();

  public static Scanner scanner = new Scanner(System.in);

  public static final String REG_LIST = "LIST\\s*+";
  public static final String REG_PHONE = "^[7|8]\\d{10}";
  public static final String REG_NAME = "[А-Яа-я]+";

  public static void main(String[] args) {
    System.out.println("Введите имя или телефонный номер");
    for (; ; ) {

      String input = scanner.nextLine();
      if (isPhone(input)) {
        if (isContainsKey(input)) {
          printContactByPhone(input);
        } else {
          String name = getInputName();
          list.put(input, name);
          System.out.println("Запись добавлена!");
          size();
          System.out.println("Введите имя или телефонный номер в формате 7/89270010000");

        }
      } else if (isName(input)) {
        if (list.containsValue(input)) {
          printContactByName(input);
        } else {
          String phoneNumber = getInputPhone();
          list.put(phoneNumber, input);
          System.out.println("Запись добавлена!");
          size();
          System.out.println("Введите имя или телефонный номер в формате 7/89270010000.");
        }
      } else if (input.matches(REG_LIST)) {
        printPhoneBook();
      } else {
        System.out.println("Не верный ввод формата.");
      }
    }
  }

  public static boolean isContainsKey(String key) {
    return list.containsKey(key);
  }

  public static boolean isName(String phoneNumber) {
    return phoneNumber.matches(REG_NAME);
  }

  public static boolean isPhone(String phoneNumber) {
    return phoneNumber.matches(REG_PHONE);
  }

  public static String getInputPhone() {
    String phoneNumber;
    for (; ; ) {
      System.out.println("Запишите номер телефона.");
      String name = new Scanner(System.in).nextLine();
      if (name.matches(REG_PHONE)) {
        if (isContainsKey(name)) {
          System.out.println("Данный  номер телефона уже существует!Используйте другой номер");
        } else {
          phoneNumber = name;
          break;
        }
      } else {
        System.out.println("Номер телефона не соответствует формату ввода!");
      }
    }
    return phoneNumber;
  }

  public static String getInputName() {
    String namePhone;
    for (; ; ) {
      System.out.println("Запишите  имя контакта.");
      String name = new Scanner(System.in).nextLine();
      if (name.matches(REG_NAME)) {
        namePhone = name;
        break;
      } else {
        System.out.println("Имя не соответствует формату ввода!");
      }
    }
    return namePhone;
  }

  public static void printPhoneBook() {
    for (String key : list.keySet()) {
      System.out.println("Имя контакта :" + " " + list.get(key) + " \t" + "Номер телефона :" + key);
    }
  }

  public static void printContactByPhone(String phoneNumber) {
    System.out.println(list.get(phoneNumber) + " " + phoneNumber);
    System.out.println("Данный  номер телефона уже существует! Измените запись.");
  }

  public static void printContactByName(String name) {
    for (Map.Entry entry : list.entrySet()) {
      if (name.equals(entry.getValue())) {
        System.out.println(entry.getValue() + " " + entry.getKey());
      }
    }
    System.out.println("Данное имя уже существует!Измените запись");
  }

  public static void size() {
    if (list.size() > 0) {
      System.out.println("Записей в телефонной книге :" + list.size());
    }
  }
}