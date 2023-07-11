import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import csvPars.ParsStationBithday;
import csvPars.StationsBirthday;
import jsonPars.ParsStationDepth;
import jsonPars.StationsDepth;
import parsSiteMetroStaton.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Serialize {


    public Serialize(String pathCsvJsonFile, SiteParse siteParse) {

        this.siteParse = siteParse;
        this.path = pathCsvJsonFile;
        createSerialize();
    }

    SiteParse siteParse;
    public String path;
    public static StationsAll stationsAll = new StationsAll();
    public static List<StationsBirthday> listDateOfCreation;

    public void createSerialize() {


        try {
            // SiteParse siteParse = new SiteParse("https://skillbox-java.github.io/", "C:\\java_basics\\FilesAndNetwork\\DataCollector\\Data\\site.html");
            Map<MetroLines, List<MoscowMetroStations>> metroLinesListMap = siteParse.getLinesAndStationListMap();
            Set<MetroLines> set = metroLinesListMap.keySet();

            for (MetroLines keyObj : set) {

                List<MoscowMetroStations> listMoscowStations = metroLinesListMap.get(keyObj);

                for (MoscowMetroStations p : listMoscowStations) {
                    JsonSerialize jsonSerialize1 = new JsonSerialize();
                    jsonSerialize1.setName(p.getStationName());
                    jsonSerialize1.setLine(keyObj.getNameLines());
                    jsonSerialize1.setDateOfCreation(setStationsBirthday(stationsAll, p));
                    jsonSerialize1.setDapth(depthSet(path, p));
                    jsonSerialize1.setHasConnection(p.isTrantitions());
                    stationsAll.addList(jsonSerialize1);

                }

            }

            jsonMapperCreateOneFile();
            jsonMapperCreateSecondFile(metroLinesListMap);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }


    public void jsonMapperCreateOneFile() {

        Path pathDirectory = Paths.get("C:\\java_basics\\FilesAndNetwork\\DataCollector\\FilesJsonSerialize");
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new SimpleModule().addSerializer(new LocalDateSerializer(DateTimeFormatter.ISO_LOCAL_DATE)));
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            if (!Files.isDirectory(pathDirectory)) {
                Files.createDirectories(pathDirectory);
            }

            Path fileJson = Path.of("stations.json");
            Path absolutePathFileJson = Path.of(pathDirectory.toString(), fileJson.toString());

            if (Files.notExists(absolutePathFileJson)) {
                Files.createFile(absolutePathFileJson);
            }

            if (Files.size(absolutePathFileJson) == 0) {
                objectMapper.writeValue(absolutePathFileJson.toFile(), stationsAll);
                System.out.println("Сериализация объктов завершена");

            }

        } catch (Exception e) {

            e.printStackTrace();
        }


    }

    public void jsonMapperCreateSecondFile(Map<MetroLines, List<MoscowMetroStations>> metroLinesListMap) throws IOException {

        Path path1 = Path.of("C:\\java_basics\\FilesAndNetwork\\DataCollector\\FilesJsonSerialize\\secondFile.json");
        Map<String, List<String>> map = mapForJsonFormat(metroLinesListMap);
        Set<MetroLines> set = metroLinesListMap.keySet();
        List<List<MoscowMetroStations>> transitions = siteParse.getTransitions();

        StationsLineTransition stationsLineTransition = new StationsLineTransition(map, transitions, set);
        ObjectMapper objectMapper = new ObjectMapper();

        if (Files.notExists(path1)) {
            Files.createFile(path1);

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(path1.toFile(), stationsLineTransition);
        } else {
            System.out.println("Файл уже создан!");
        }

    }


    public Map<String, List<String>> mapForJsonFormat(Map<MetroLines, List<MoscowMetroStations>> metroLinesListMap) {

        Map<String, List<String>> map = new LinkedHashMap<>();
        Iterator<Map.Entry<MetroLines, List<MoscowMetroStations>>> iterator = metroLinesListMap.entrySet().iterator();

        while (iterator.hasNext()) {

            Map.Entry<MetroLines, List<MoscowMetroStations>> entry = iterator.next();

            MetroLines metroLines = entry.getKey();
            List<MoscowMetroStations> list = entry.getValue();
            List<String> list1 = list.stream().map(MoscowMetroStations::getStationName).collect(Collectors.toList());
            map.put(metroLines.getNumberLine(), list1);
        }
        return map;
    }


    public LocalDate setStationsBirthday(StationsAll stationsAll, MoscowMetroStations metroStations) {
        LocalDate localDate = null;

        try {

            if (listDateOfCreation == null) {
                allDataFromCsv(path);
            }

            for (int i = 0; listDateOfCreation.size() > i; i++) {

                if (listDateOfCreation.get(i).getStationName().equalsIgnoreCase(metroStations.getStationName())) {

                    localDate = listDateOfCreation.get(i).getLocalDate();
                    listDateOfCreation.remove(i);
                    break;
                } else {

                    List<JsonSerialize> list = stationsAll.getStation();

                    for (JsonSerialize pre : list) {

                        if (pre.getName().equalsIgnoreCase(metroStations.getStationName()) && pre.getDateOfCreation() != null) {

                            localDate = pre.getDateOfCreation();
                        }

                    }

                }

            }

        } catch (IOException e) {

            System.out.println(e.getMessage() + " error");
            e.printStackTrace();
        }
        return localDate;
    }

    public void allDataFromCsv(String path) throws IOException {

        List<Path> paths = Files.walk(Path.of(path)).filter((pre) -> pre.toString().endsWith(".csv")).collect(Collectors.toList());
        ParsStationBithday parsStationBithday = new ParsStationBithday(paths);

        listDateOfCreation = parsStationBithday.getListDateOfCreation();
    }

    public List<StationsDepth> allDataFromJson(String path) throws IOException {

        List<StationsDepth> allStationsDepth = allDepth(path);

        List<StationsDepth> stationsDepth = new ArrayList<>();

        for (int i = 0; allStationsDepth.size() > i; i++) {

            int searchCount = Collections.binarySearch(stationsDepth, allStationsDepth.get(i));
            if (searchCount < 0) {

                stationsDepth.add(allStationsDepth.get(i));

            } else {
                String one = allStationsDepth.get(i).getDepth();
                String second = stationsDepth.get(searchCount).getDepth();

                if (Objects.isNull(second) && Objects.nonNull(one)) {
                    stationsDepth.set(searchCount, allStationsDepth.get(i));

                } else if (Objects.nonNull(second) && Objects.nonNull(one)) {

                    double x = Double.parseDouble(stationsDepth.get(searchCount).getDepth().replace(",", "."));
                    double y = Double.parseDouble(allStationsDepth.get(i).getDepth().replace(",", "."));
                    int z = Double.compare(x, y);
                    if (z > 0) {
                        stationsDepth.set(searchCount, allStationsDepth.get(i));

                    }
                }
            }
        }

        return stationsDepth;

    }

    public List<StationsDepth> allDepth(String path) throws IOException {
        List<StationsDepth> stationsDepth = new ArrayList<>();

        List<Path> stationsPath = Files.walk(Path.of(path))
                .filter((pre) -> pre.toString().endsWith(".json"))
                .collect(Collectors.toList());

        for (Path p : stationsPath) {
            ParsStationDepth parsStationDepth = new ParsStationDepth(p.toString());
            stationsDepth.addAll(parsStationDepth.getStationList());
        }

        Collections.sort(stationsDepth);
        return stationsDepth;
    }

    public String depthSet(String path, MoscowMetroStations metroStations) throws IOException {

        List<StationsDepth> listDepth = allDataFromJson(path);

        for (StationsDepth pre : listDepth) {

            if (pre.getStationName().equals(metroStations.getStationName())) {

                return pre.getDepth();

            }
        }

        return null;
    }

}

