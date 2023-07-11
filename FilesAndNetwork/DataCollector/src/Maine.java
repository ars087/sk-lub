import jsonPars.StationsDepth;
import parsSiteMetroStaton.SiteParse;
import searchFileInDirectory.SearchFileOfDirectory;

import java.util.List;

public class Maine {


    public static void main(String[] args) throws Throwable {

        //  SearchFileOfDirectory searchFileOfDirectory = new SearchFileOfDirectory("C:\\Users\\skillbox\\Downloads\\stations-data (1)\\data","C:\\java_basics\\FilesAndNetwork\\DataCollector\\Data");
        SiteParse siteParse = new SiteParse("https://skillbox-java.github.io/", "C:\\java_basics\\FilesAndNetwork\\DataCollector\\Data\\site.html");

        Serialize serialize = new Serialize("C:\\java_basics\\FilesAndNetwork\\DataCollector\\Data", siteParse);

    }


}
