import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class CoolNumbers {

  public static final String[] lettersLicensePlates = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С",
      "Т", "У", "Х"};
  public static final String REG_ADD_REGION = "[1-9]{1,3}";
  public static final String REG_NUMBER_CAR = "[А-Я](\\d{1,3})[А-Я]{1,3}\\d{1,3}";

  public static final HashSet<String> COLECTION_NUMBER_HASH = new HashSet<>();
  public static final TreeSet<String> COLECTION_NUMBER_SET = new TreeSet<>();
  public static final ArrayList<String> COLECTION_NUMBER_LIST = new ArrayList<>();
  public static final ArrayList<String> REGION_NUMBERS = new ArrayList<>();
    public static void main(String[] args) {

    for (; ; ) {

      System.out.print("Введите  номер региона   либо команду!");
      Scanner scanner = new Scanner(System.in);
      String valueInput = scanner.nextLine();

      inputRegion(valueInput);
     binarySearch(valueInput,COLECTION_NUMBER_SET);
      //containsSearch(valueInput,COLECTION_NUMBER_LIST);
      printArray(valueInput);

      if (!valueInput.matches(REG_ADD_REGION) && !valueInput.equals("PRINT") && !valueInput
          .matches(REG_NUMBER_CAR)) {

        System.out.println("Команда введена в неверном формате");
      }

    }////////////конец функции.

  }


  public static void generateCoolNumbers(String regionCode) {

    String zero = "0";
    int parseIntRegion = Integer.parseInt(regionCode);
    if (parseIntRegion < 10) {

      String temp = regionCode;
      regionCode = zero;
      regionCode += zero + temp;

    }

    for (int i = 111; i <= 999; i += 111) {

      for (int g = 0; g < lettersLicensePlates.length; g++) {

        for (int q = 0; q < lettersLicensePlates.length; q++) {

          for (int h = 0; h < lettersLicensePlates.length; h++) {

           /* System.out.printf("%s%03d%s%02d\n", lettersLicensePlates[g], i,
                lettersLicensePlates[q] + lettersLicensePlates[h], regionCode);*/

            String regionNumber = lettersLicensePlates[g] + i +
                lettersLicensePlates[q] + lettersLicensePlates[h] + regionCode;

            //   System.out.println( num );
            COLECTION_NUMBER_LIST.add(regionNumber);
            COLECTION_NUMBER_SET.add(regionNumber);
            COLECTION_NUMBER_HASH.add(regionNumber);

          }
        }

      }
    }

    System.out.println("База номеров сгенерированна!");

  }


  public static void binarySearch(String carNumber,Collection collection) {

    if (carNumber.matches(REG_NUMBER_CAR) && sizeArray(collection)) {

      Collections.sort(COLECTION_NUMBER_LIST);
      long start = System.nanoTime();
      int foundNumber = Collections.binarySearch(COLECTION_NUMBER_LIST, carNumber);
      long finish = System.nanoTime();

      if (foundNumber >= 0) {

        System.out.println(
            "Номер автомобиля найден!" +  COLECTION_NUMBER_LIST.get(foundNumber)  + " Позиция на строке базы №"
                + foundNumber);

        System.out.println("Время  успешного поиска в НС - " + (start - finish) + " в МС" + ((start - finish) / 1000));

      } else   {
        System.out.println("Номер в базе отсутствует!");

        System.out.println("Время не успешного поиска в НС - " + (start - finish) + " в МС" + ((start - finish) / 1000) );

      }


    }


  }

  public static void containsSearch(String carNumber, Collection collection) {


    if (carNumber.matches(REG_NUMBER_CAR) && sizeArray(collection)) {
      long start = System.nanoTime();
      if (COLECTION_NUMBER_LIST.contains(carNumber)) {
        long finish = System.nanoTime();
        System.out.println("Номер автомобиля найден!" + carNumber);
        System.out.println("Время успешного поиска в НС - " + (start - finish) + " в МС"+((start - finish) / 1000) );
      } else {long finishSecond = System.nanoTime();
                System.out.println("Номер в базе отсутствует!");

        System.out.println("Время не успешного поиска в НС - " + (start - finishSecond) + " в МС"+((start - finishSecond) / 1000));

      }
    }
  }


  public static String inputRegion(String regionCode) {

    if (regionCode.matches(REG_ADD_REGION)) {

      if (REGION_NUMBERS.contains(regionCode)) {
        System.out.println(
            "База автомобильных номеров с таким кодом региона уже существует.Введите иной код региона!");
      } else {
        REGION_NUMBERS.add(regionCode);

        generateCoolNumbers(regionCode);

      }


    }

    return regionCode;
  }


  public static String printArray(String print) {

    if (print.equals("PRINT")) {

      for (String i : COLECTION_NUMBER_LIST) {

        System.out.println(i);

      }


    }

    return print;
  }

  public static boolean sizeArray( Collection collection) {



  boolean isSize;

    if (collection.size() == 0) {

      System.out.println(
          "База номеров отсутствует! Сгенерируйте базу  введя необходимый код региона!");

       isSize= false;
    } else { isSize = true;}

   return isSize;
  }


}