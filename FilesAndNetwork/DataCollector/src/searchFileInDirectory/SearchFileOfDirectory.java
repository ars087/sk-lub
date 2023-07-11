package searchFileInDirectory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SearchFileOfDirectory {

    String whereToCopy;
    String storage;

    public SearchFileOfDirectory(String whereToCopy, String storage) {

        this.whereToCopy = whereToCopy;
        this.storage = storage;

        copyFile(whereToCopy);
    }


    private List<Path> searchPath(String whereToCopy) {

        List<Path> listPath = new ArrayList<>();
        try {
            Path path1 = Path.of(whereToCopy);

            String[] mass = new String[]{".json", ".csv"};

            for (String p : mass) {

                Files.walk(path1)
                        .filter((pre) -> pre.toString().endsWith(p))
                        .forEach(listPath::add);
            }
        } catch (Exception ex) {
            //throw new RuntimeException(ex);
             System.out.println(ex.getMessage()+ "-не верно указан  путь ");;

        }

        return listPath;
    }

    public void copyFile(String whereToCopy) {

        List<Path> list = searchPath(whereToCopy);

        list.forEach((pre) -> {
            try {
                Path path3 = Paths.get(storage, pre.getFileName().toString());

                if (!Files.isDirectory(Path.of(storage))) {
                    Files.createDirectories(Path.of(storage));
                }
                if (Files.notExists(path3)) {
                    Files.copy(pre, path3);
                    System.out.println("Копия файла создана");
                } else if (Files.exists(path3)) {
                    System.out.println("Файл уже создан");

                } else {
                    System.out.println("Путь к файлу указан не верно");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println(pre);
        });


    }


}