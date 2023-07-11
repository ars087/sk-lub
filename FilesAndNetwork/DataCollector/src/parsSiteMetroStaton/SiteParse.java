package parsSiteMetroStaton;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class SiteParse {
    String pathToSite;
    String fileStoragePath;


    public List<List<MoscowMetroStations>> transitions = new LinkedList<>();
    public Map<MetroLines, List<MoscowMetroStations>> linesAndStationsListMap = new LinkedHashMap<>();

    public SiteParse(String pathToSite, String fileStoragePath) throws Throwable {

        this.pathToSite = pathToSite;
        this.fileStoragePath = fileStoragePath;
        parsSiteSoup(pathToSite, fileStoragePath);
        readFromFileSite(fileStoragePath);

    }

    public Map<MetroLines, List<MoscowMetroStations>> getLinesAndStationListMap() {
        return linesAndStationsListMap;
    }

    public void parsSiteSoup(String pathToSite, String fileStoragePath) throws IOException {

        Document document = Jsoup.connect(pathToSite).get();
        String st = document.outerHtml();
        Path of = Path.of(fileStoragePath);
        Files.write(of, st.getBytes());

    }



    public List<List<MoscowMetroStations>> getTransitions() {
        return transitions;
    }

    public void readFromFileSite(String fileStoragePath) throws IOException {

        Document document1 = Jsoup.parse(Files.readString(Path.of(fileStoragePath)));
        Elements elements = document1.getElementsByAttributeStarting("data-depend-set");

        for (int i = 0; elements.size() > i; i++) {

            String nameLines = Objects.requireNonNull(elements.get(i).previousElementSibling()).select("span").text();
            String numberLine = Objects.requireNonNull(elements.get(i).previousElementSibling()).select("span").attr("data-line");
            MetroLines metroLines = new MetroLines(nameLines, numberLine);
            int s = elements.get(i).getElementsByTag("p").size();

             List<MoscowMetroStations> stations = new LinkedList<>();
            for (int y = 0; s > y; y++) {

                String nameStation = elements.get(i).getElementsByTag("p").get(y).getElementsByClass("name").text();
                int childrenSize = elements.get(i).getElementsByTag("p").get(y).childrenSize();
                Elements element = elements.get(i).getElementsByTag("p").get(y).children();
                 MoscowMetroStations metroStations = new MoscowMetroStations(nameStation, numberLine);

               if (childrenSize > 2) {

                    metroStations.setTrantitions(true);
                    readTransitions(element, childrenSize, metroStations);

                }
                stations.add(metroStations);
            }
            linesAndStationsListMap.put(metroLines, stations);


        }

    }


    public void readTransitions(Elements element, int childrenSize, MoscowMetroStations metroStations) {

        List<MoscowMetroStations> transitionsStationsList = new ArrayList<>();
        transitionsStationsList.add(metroStations);
            for (int q = 2; childrenSize > q; q++) {

                String atteClass = element.get(q).attr("class");
                String numberLineMetro = atteClass.substring(atteClass.lastIndexOf("-") + 1);
                String attrTitle = element.get(q).attr("title");
                String stationName = attrTitle.substring(attrTitle.indexOf("«") + 1, attrTitle.lastIndexOf("»"));
                metroStations = new MoscowMetroStations(stationName, numberLineMetro);
                transitionsStationsList.add( metroStations);
                metroStations.setTrantitions(true);

            }
           if (! transitions.contains(transitionsStationsList)  ){
              transitions.add(transitionsStationsList);}

    }


    public void printMap() {

        if (!linesAndStationsListMap.isEmpty()) {
            Iterator<Map.Entry<MetroLines, List<MoscowMetroStations>>> iterator = linesAndStationsListMap.entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry<MetroLines, List<MoscowMetroStations>> entry = iterator.next();
                MetroLines metroLines1 = entry.getKey();
                System.out.println( metroLines1.getNameLines() + "   " + metroLines1.getNumberLine());
                List<MoscowMetroStations> list = entry.getValue();

                list.forEach((pre)-> System.out.println("\t" + pre.getStationName()) );

            }

        }

    }

}




















