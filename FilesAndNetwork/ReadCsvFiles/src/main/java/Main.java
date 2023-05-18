import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException, CsvException {
        String path = "C:\\java_basics\\FilesAndNetwork\\ReadCsvFiles\\src\\test\\resources\\MovementList.csv";
        Movements movements = new Movements(path);

        List<String[]> mass = movements.getReadFromFile();
        HashMap<String, Double> hashMap = new HashMap<>();
        //  mass.forEach((w)->System.out.println(  Arrays.toString(w)));

        try {
            for (String[] p : mass) {
                if (!p[7].equals("0")) {
                    String replaceString = p[5].replace(">", "\\");
                    Double aDouble = Double.parseDouble(p[7].replace(",", "."));
                    String subStr = replaceString.substring(replaceString.lastIndexOf("\\") + 1, replaceString.indexOf("       "));
                    if (!hashMap.containsKey(subStr)) {
                        hashMap.put(subStr, aDouble);
                    } else {
                        hashMap.put(subStr, aDouble + hashMap.get(subStr));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Set<String> strings = hashMap.keySet();
        strings.forEach((p) -> System.out.println(p + "  " + hashMap.get(p)));

    }
}















