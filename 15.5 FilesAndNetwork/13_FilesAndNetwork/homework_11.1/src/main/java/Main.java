import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner;


    public static void main(String[] args) {
        for (; ; ) {
            System.out.println(" Введите путь к файлу");
            scanner = new Scanner(System.in);
            String path = scanner.nextLine().trim();

            try {

                double sizSumm = pathFileTwo(path);
                double kilobyteSize = sizSumm / 1024.0;
                double megabyteSize = sizSumm / Math.round(Math.pow(1024, 2));
                double gigabyteSize = sizSumm / Math.round(Math.pow(1024, 3));

                if (sizSumm > 0) {

                    System.out.format("Размер директории  %s : %.2f %s %n", path, kilobyteSize, "KB");
                    System.out.printf("Размер директории  %s : %.2f %s %n", path, megabyteSize, "MB");
                    System.out.printf("Размер директории  %s : %.2f %s %n", path, gigabyteSize, "GB");

                }
            } catch (Exception ex) {

                System.out.println(Arrays.toString(ex.getStackTrace()));
                System.out.println(ex.getMessage());

            }
        }

    }
    static public double pathFileTwo(String string) throws IOException {

        Path folder = Paths.get(string);
        if (Files.exists(folder)) {
            return Files.walk(folder)
                    .filter(p -> p.toFile().isFile())
                    .mapToDouble(p -> p.toFile().length())
                    .sum();
        } else {
            System.out.println("По данному пути отсутствует директория");
        }
        return 0;
    }
}
