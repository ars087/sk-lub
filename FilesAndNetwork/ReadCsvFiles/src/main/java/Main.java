import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import net.sf.saxon.expr.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException, CsvException {

        String path = "C:\\java_basics\\FilesAndNetwork\\ReadCsvFiles\\src\\test\\resources\\MovementList.csv";
        String pathOne = "C:\\java_basics\\FilesAndNetwork\\ReadCsvFiles\\src\\test\\resources\\MovementListFloat.csv";
        String pathTwo = "C:\\java_basics\\FilesAndNetwork\\ReadCsvFiles\\src\\test\\resources\\MovementListInteger.csv";
          Movements movements = new Movements(pathOne);


        System.out.println( movements.getExpenseSum());

        System.out.println( movements.getIncomeSum());


    }


}


