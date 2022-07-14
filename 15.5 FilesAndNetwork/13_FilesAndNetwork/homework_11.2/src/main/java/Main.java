
import java.nio.file.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {

        try {
            for (; ; ) {
                Path path = inputPathExists("Введите путь к исходной директории, либо файлу для копирования");
                Path path1 = inputPathExists("Введите путь к директории  для копирования");

                 Files.walkFileTree(path,new FileUtils(path,path1));
                System.out.println("Копирование завершено.!");
            }
        } catch (Exception ex) {

            System.out.println(Arrays.toString(ex.getStackTrace()));
            System.out.println(ex.getMessage());

        }

    }

        public static Path inputPathExists (String message)  throws Exception {

            for (; ; ) {

                System.out.println(message);
                Scanner scanner = new Scanner(System.in);
                String scannerPath = scanner.nextLine().trim();
                Path path = Paths.get(scannerPath);
                if (Files.exists(path)) {
                   return path;
                } else {
                    System.out.println("Указанного пути не существует!");
                }
            }
        }

}

