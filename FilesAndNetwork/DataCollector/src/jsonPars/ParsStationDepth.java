package jsonPars;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ParsStationDepth {


    public ParsStationDepth(String pathToJson) throws IOException {


        addToListJson(pathToJson);
    }

    public List<StationsDepth> stationList;


    public List<StationsDepth> getStationList() {


        return stationList;
    }

    public void addToListJson(String pathToJson) {

        try {

            Path path = Path.of(pathToJson);

            String jsonRead = Files.readString(path);

            ObjectMapper objectMapper = new ObjectMapper();

            CollectionType objectMapper1 = objectMapper.getTypeFactory().constructCollectionType(List.class, StationsDepth.class);

            stationList = objectMapper.readValue(jsonRead, objectMapper1);


        } catch (IOException e) {

            System.out.println(e.getMessage() + "Отсутствует файл в переданном пути, либо путь указан не верно");
        }

    }

    public void printStations() {

        stationList.forEach((r) -> System.out.println(r.getStationName() + " " + r.getDepth()));

    }


}
