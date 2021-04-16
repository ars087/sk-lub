import java.util.ArrayList;
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

    public static final ArrayList<String> COLLECTION_NUMBER_LIST = new ArrayList<>();
    public static final TreeSet<String> COLLECTION_NUMBER_SET = new TreeSet<>();
    public static final HashSet<String> COLLECTION_NUMBER_HASH = new HashSet<>();

    public static void main(String[] args) {

        generateCoolNumbers();
        System.out.println("База номеров сгенерирована!");

        for (; ; ) {

            System.out.print("Введите регистрационный номер автомобиля, либо команду!");
            Scanner scanner = new Scanner(System.in);
            String valueInput = scanner.nextLine();

            if (valueInput.matches("PRINT")) {
                printArray();
            } else if (valueInput.matches(REG_NUMBER_CAR)) {
                searchInArrayList(valueInput, COLLECTION_NUMBER_LIST);
                searchInTreeSet(valueInput, COLLECTION_NUMBER_SET);
                searchInHashSet(valueInput, COLLECTION_NUMBER_HASH);
            } else {
                System.out.println("Команда введена в неверном формате");
            }
        }
    }

    public static void generateCoolNumbers() {

        System.out.println("Ожидайте, база номеров формируется...");

        for (int region = 1; region <= 199; region++) {

            String regionCode;

            regionCode = getRegionCode(region);

            for (int i = 111; i <= 999; i += 111) {

                for (String lettersLicensePlate : lettersLicensePlates) {

                    for (String licensePlate : lettersLicensePlates) {

                        for (String plate : lettersLicensePlates) {

                            String regionNumber = lettersLicensePlate + i +
                                    licensePlate + plate + regionCode;

                            COLLECTION_NUMBER_LIST.add(regionNumber);
                            COLLECTION_NUMBER_SET.add(regionNumber);
                            COLLECTION_NUMBER_HASH.add(regionNumber);
                        }
                    }
                }
            }
        }
    }

    private static String getRegionCode(int region) {
        String regionCode;
        if (region <= 9) {
            String zero = "0";
            String temp = String.valueOf(region);
            regionCode = zero;
            regionCode += zero + temp;
        } else {
            regionCode = String.valueOf(region);
        }
        return regionCode;
    }

    public static void printArray() {

        for (String i : COLLECTION_NUMBER_LIST) {

            System.out.println(i);
        }
    }

    public static void searchInArrayList(String value, ArrayList<String> list) {

        long start = System.nanoTime();
        if (list.contains(value)) {
            long finish = System.nanoTime();

            System.out.println(
                    "Номер автомобиля найден!" + value);

            printSearchResult(" Метод поиска  contains в ArrayList.", finish - start);

        } else {
            long finishSecond = System.nanoTime();
            System.out.println("Номер в базе отсутствует!");

            printSearchResult("Метод поиска  contains в ArrayList.", finishSecond - start);
        }

        Collections.sort(list);
        long startOne = System.nanoTime();
        int foundNumber = Collections.binarySearch(list, value);
        long finish = System.nanoTime();
        if (foundNumber >= 0) {
            System.out.println("Номер автомобиля найден!");
            printSearchResult("Метод поиска  binarySearch в ArrayList.", finish - startOne);
        } else {
            long finishTwo = System.nanoTime();
            System.out.println("Номер в базе отсутствует!");

            printSearchResult("Метод поиска  binarySearch в ArrayList.", finishTwo - startOne);
        }
    }

    public static void searchInTreeSet(String value, TreeSet<String> set) {

        long start = System.nanoTime();
        if (set.contains(value)) {
            long finish = System.nanoTime();
            System.out.println(
                    "Номер автомобиля найден!" + value);
            printSearchResult("Метод поиска contains TreeSet", finish - start);

        } else {
            long finishSecond = System.nanoTime();
            System.out.println("Номер в базе отсутствует!");

            printSearchResult("Метод поиска contains в TreeSet", finishSecond - start);
        }
    }

    private static void printSearchResult(String text, long duration) {
        System.out.println(
                text + " Время поиска в НС" + duration
                        + " в МИК."
                        + (duration / 1000));
    }

    public static void searchInHashSet(String value, HashSet<String> set) {

        long start = System.nanoTime();
        if (set.contains(value)) {
            long finish = System.nanoTime();
            System.out.println(
                    "Номер автомобиля найден!" + value);
            printSearchResult("Метод поиска contains в HashSet", finish - start);
        } else {
            long finishSecond = System.nanoTime();
            System.out.println("Номер в базе отсутствует!");
            printSearchResult("Метод поиска contains в HashSet", finishSecond - start);
        }
    }
}