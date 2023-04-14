import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Movements {


    public Optional<Double> optionalIncome;
    public Optional<Double> optionalExpense;


    public Movements(String pathMovementsCsv) throws IOException, CsvException {

        countIncomSum(pathMovementsCsv);
        countExpenseSum(pathMovementsCsv);

    }

    public double getExpenseSum() {

        return optionalExpense.orElseGet(() -> optionalExpense.get());

    }

    public double getIncomeSum() {


        return optionalIncome.orElseGet(() -> optionalIncome.get());

    }

    public void countIncomSum(String pathString) throws IOException, CsvException {


        Reader reader = new FileReader(pathString);

        CSVParser parserBuilder = new CSVParserBuilder()

                .build();

        CSVReader csvReader = new CSVReaderBuilder(reader)
                .withSkipLines(1)
                .withCSVParser(parserBuilder)
                .build();

        List<String[]> mass = csvReader.readAll();
        optionalIncome = mass
                .stream()
                .flatMap((pre) -> {
                    return Arrays.stream(pre, 6, 7);
                })
                .map(d -> d.replaceAll(",", "."))
                .map(Double::parseDouble)

                .reduce(Double::sum);


    }

    public void countExpenseSum(String pathString) throws IOException, CsvException {

        Reader reader = new FileReader(pathString);

        CSVParser parserBuilder = new CSVParserBuilder()

                .build();

        CSVReader csvReader = new CSVReaderBuilder(reader)
                .withSkipLines(1)
                .withCSVParser(parserBuilder)
                .build();

        List<String[]> mass = csvReader.readAll();
        optionalExpense = mass
                .stream()
                .flatMap((pre) -> {
                    return Arrays.stream(pre, 7, 8);
                })
                .map(d -> d.replaceAll(",", "."))
                .map(Double::parseDouble)
                .reduce(Double::sum);


    }


}



