import java.util.ArrayList;
import java.util.List;

public class StationsAll {

    public List<JsonSerialize> station = new ArrayList<>();

    public void setStation(JsonSerialize station) {
        this.station.add(station);
    }

    public List<JsonSerialize> getStation() {
        return station;
    }

    public void addList(JsonSerialize jsonSerialize) {

        station.add(jsonSerialize);

    }

}