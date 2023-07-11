package csvPars;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParsStationBithday {


    public ParsStationBithday(String pathToCsv) {


        addToObject(dataFromFile(pathToCsv));

    }

    public ParsStationBithday(List<Path> paths) {

        pathList(paths);

    }

    public List<StationsBirthday> listDateOfCreation = new ArrayList<>();

    public List<StationsBirthday> getListDateOfCreation() {
        return listDateOfCreation;
    }

    public List<String[]> dataFromFile(String pathToCsv) {

        try {
            Reader reader = new FileReader(pathToCsv);
            CSVParser csvParser = new CSVParserBuilder()
                    .build();
            CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withSkipLines(1)
                    .withCSVParser(csvParser)
                    .build();
            return csvReader.readAll();

        } catch (Exception e) {
            System.out.println(e.getMessage() + "Файл отсутствует либо путь к файлу указан не верно");

        }
        return null;
    }

    public void addToObject(List<String[]> list) {

        for (String[] mass : list) {

            StationsBirthday dateOfCreation = new StationsBirthday(mass[0], parsLocalDate(mass[1]));
            if (Collections.binarySearch(listDateOfCreation, dateOfCreation) < 0) {
                listDateOfCreation.add(dateOfCreation);

            }
        }
    }

    public LocalDate parsLocalDate(String dateOfCreation) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        return LocalDate.parse(dateOfCreation, dateTimeFormatter);
    }

    public void printStations() {
        if (!listDateOfCreation.isEmpty()) {
            listDateOfCreation.forEach((p) -> System.out.println(p.getStationName() + " " + p.getLocalDate()));
        } else {
            System.out.println("Коллекция не имеет записей");
        }
    }


    public void pathList(List<Path> listPath) {

        List<List<String[]>> list = new ArrayList<>();

        for (Path path : listPath) {

            list.add(dataFromFile(path.toString()));

        }

        for (List<String[]> strMass : list) {

            addToObject(strMass);

        }

    }

}



