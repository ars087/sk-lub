

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {

        Document document = Jsoup.connect("https://lenta.ru/").get();


        Elements elements = document.getElementsByTag("img");

        for (Element element : elements) {
            try {
                String pathToPhoto = new String(element.absUrl("src").getBytes(), StandardCharsets.UTF_8);

                URL url = new URL(pathToPhoto);
                Path pathGetPhoto = Paths.get(url.getPath());

                String nameFile = pathGetPhoto.getFileName().toString();

                Path pathDirectory = Paths.get("src\\main\\imgCollection");

                if (!Files.exists(pathDirectory)) {
                    Files.createDirectory(pathDirectory);
                    System.out.println("Создана директория : imgCollection");
                }
                Path path = Path.of(pathDirectory.toString(), nameFile);

                File file = new File(path.toString());

                if (!file.isFile()) {

                    InputStream inputStream = url.openStream();
                    Files.copy(inputStream, path);
                    System.out.println(file.getName());

                }

            } catch (Exception e) {

                e.getStackTrace();

            }

        }

    }

}
