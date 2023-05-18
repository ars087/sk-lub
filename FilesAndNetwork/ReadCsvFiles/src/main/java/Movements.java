import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Movements {

    public List<String[]> readFromFileToList = new ArrayList<>() {
    };

    public String path;

    public Movements(String pathMovementsCsv) throws IOException, CsvException {

        path = pathMovementsCsv;
        parsFile(pathMovementsCsv);
    }

    public List<String[]> getReadFromFile() {
        return readFromFileToList;
    }

    public double getIncomeSum() {
        return readFromFileToList
                .stream()
                .flatMap((p) -> {
                    return Arrays.stream(p, 6, 7);
                })
                .map(d -> d.replace(",", "."))
                .mapToDouble(Double::parseDouble)
                .sum();

    }

    public double getExpenseSum() {

        return readFromFileToList
                .stream()
                .flatMap((p) -> Arrays.stream(p, 7, 8))
                .map(d -> d.replace(",", "."))
                .mapToDouble(Double::parseDouble)
                .sum();

    }

    public void parsFile(String pathString) throws IOException, CsvException {

        Reader reader = new FileReader(pathString);
        CSVParser parserBuilder = new CSVParserBuilder()
                 .withEscapeChar('\'')
                .build();
        CSVReader csvReader = new CSVReaderBuilder(reader)
                .withSkipLines(1)
                .withCSVParser(parserBuilder)
                .build();
        readFromFileToList = csvReader.readAll();

    }

    public double getExpenseSumSecond() {   //метод работает быстрее чем стримы

        double sum = 0;
        for (String[] r : readFromFileToList) {

            sum += Double.parseDouble(r[7].replace(",", "."));
        }
        return sum;
    }
}



