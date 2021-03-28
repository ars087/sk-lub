import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CoolNumbers {

  public static final String[] lettersLicensePlates = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С",
      "Т", "У", "Х"};

  public static final String REG_NUMBER_CAR = "[А-Я](\\d{1,3})[А-Я]{1,3}\\d{1,3}";

  public static final List<String> COLECTION_NUMBER_LIST = new ArrayList<>();
  public static final Set<String> COLECTION_NUMBER_SET = new TreeSet<>();
  public static final Set<String> COLECTION_NUMBER_HASH = new HashSet<>();

  public static void main(String[] args) {

    generateCoolNumbers();
    System.out.println("База номеров сгенерирована!");

    for (; ; ) {

      System.out.print("Введите регистрационный номер автомобиля, либо команду!");
      Scanner scanner = new Scanner(System.in);
      String valueInput = scanner.nextLine();
      printArray(valueInput);
      if (valueInput.matches(REG_NUMBER_CAR)) {

        searchInArrayList(valueInput, COLECTION_NUMBER_LIST);
        searchInTreeSet(valueInput, COLECTION_NUMBER_SET);
        searchInHashSet(valueInput, COLECTION_NUMBER_HASH);


      } else if (!valueInput.equals("PRINT") && !valueInput
          .matches(REG_NUMBER_CAR)) {

        System.out.println("Команда введена в неверном формате");
      }

    }

  }


  public static void generateCoolNumbers() {

    for (int region = 1; region <= 199; region++) {

      String regionCode;

      if (region <= 9) {
      String zero = "0";
      String temp = String.valueOf(region);
      regionCode = zero;
       regionCode += zero + temp;
    }else { regionCode = String.valueOf(region);   }

    for (int i = 111; i <= 999; i += 111) {

      for (int g = 0; g < lettersLicensePlates.length; g++) {

        for (int q = 0; q < lettersLicensePlates.length; q++) {

          for (int h = 0; h < lettersLicensePlates.length; h++) {

            String regionNumber = lettersLicensePlates[g] + i +
                lettersLicensePlates[q] + lettersLicensePlates[h] + regionCode;

            COLECTION_NUMBER_LIST.add(regionNumber);
            COLECTION_NUMBER_SET.add(regionNumber);
            COLECTION_NUMBER_HASH.add(regionNumber);

          }
        }

      }
    }


    }


  }


  public static void printArray(String print) {

    if (print.equals("PRINT")) {

      for (String i : COLECTION_NUMBER_LIST) {

        System.out.println(i);

      }


    }


  }


  public static void searchInArrayList(String value, List list) {

    long start = System.nanoTime();
    if (list.contains(value)) {
      long finish = System.nanoTime();

      System.out.println(
          "Номер автомобиля найден!" + value);

      System.out.println(
          " Метод поиска  contains в ArrayList. Время успешного поиска в НС  - " + (finish - start)
              + " в МС" + (
              (finish - start) / 1000));

    } else {
      long finishSecond = System.nanoTime();
      System.out.println("Номер в базе отсутствует!");

      System.out.println(
          "Метод поиска  contains в ArrayList . Время не успешного поиска в НС - " + (finishSecond
              - start) + " в МС"
              + ((finishSecond - start) / 1000));

    }

    Collections.sort(list);
    long startOne = System.nanoTime();
    int foundNumber = Collections.binarySearch(list, value);
    long finish = System.nanoTime();
    if (foundNumber >= 0) {
      System.out.println("Номер автомобиля найден!");

      System.out.println(
          "Метод поиска  binarySearch в ArrayList . Время  успешного поиска в НС - " + (finish
              - startOne) + " в МС" + (
              (finish - startOne) / 1000));
    } else {
      long finishTwo = System.nanoTime();
      System.out.println("Номер в базе отсутствует!");

      System.out.println(
          "Метод поиска  binarySearch в ArrayList.Время не успешного поиска в НС - " + (finishTwo
              - startOne) + " в МС" + ((finishTwo - startOne)
              / 1000));
    }

  }

  public static void searchInTreeSet(String value, Set set) {

    long start = System.nanoTime();
    if (set.contains(value)) {
      long finish = System.nanoTime();
      System.out.println(
          "Номер автомобиля найден!" + value);
      System.out.println(
          " Метод поиска  contains в TreeSet . Время успешного поиска в НС  - " + (finish - start)
              + " в МС" + (
              (finish - start) / 1000));

    } else {
      long finishSecond = System.nanoTime();
      System.out.println("Номер в базе отсутствует!");

      System.out.println(
          "Метод contains в TreeSet. Время не успешного поиска в НС - " + (finishSecond - start)
              + " в МС"
              + ((finishSecond - start) / 1000));

    }


  }


  public static void searchInHashSet(String value, Set set) {

    long start = System.nanoTime();
    if (set.contains(value)) {
      long finish = System.nanoTime();
      System.out.println(
          "Номер автомобиля найден!" + value);
      System.out.println(
          " Метод поиска  contains в HashSet . Время успешного поиска в НС  - " + (finish - start)
              + " в МС" + (
              (finish - start) / 1000));
    } else {
      long finishSecond = System.nanoTime();
      System.out.println("Номер в базе отсутствует!");

      System.out.println(
          "Метод contains в HashSet. Время не успешного поиска в НС - " + (finishSecond - start)
              + " в МС"
              + ((finishSecond - start) / 1000));

    }


  }

}