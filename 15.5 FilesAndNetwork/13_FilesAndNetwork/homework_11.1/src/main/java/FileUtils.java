import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    public static long calculateFolderSize(String path) throws IOException {

        Path folder = Paths.get(path);


        if (Files.exists(folder)) {

            return (long) Files.walk(folder)
                    .filter(p -> p.toFile().isFile())
                    .mapToDouble(p -> p.toFile().length())
                    .sum();
        } else {
            System.out.println("По данному пути отсутствует директория");

        }

        return 0;
    }
}
