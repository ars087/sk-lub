package parsSiteMetroStaton;

import net.sf.saxon.expr.Component;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class MoscowMetroStations implements Comparable<MoscowMetroStations> {
    public MoscowMetroStations(String nameStation, String metroLines) {

        this.stationName = parsNameStation(nameStation);
        this.numberMetroLines = metroLines;

    }

    String stationName;
    String numberMetroLines;

    boolean trantitions = false;

    public boolean isTrantitions() {
        return trantitions;
    }

    public void setTrantitions(boolean trantitions) {
        this.trantitions = trantitions;
    }


    public String getNumberMetroLines() {
        return numberMetroLines;
    }

    public void setNumberMetroLines(String numberMetroLines) {
        this.numberMetroLines = numberMetroLines;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }


    public String parsNameStation(String stationName) {


        return StringUtils.stripAccents(stationName);


    }


    @Override
    public boolean equals(Object obj) {
        MoscowMetroStations moscowMetroStations = (MoscowMetroStations) obj;

        return this.stationName.equals(moscowMetroStations.getStationName());
    }

    @Override
    public int compareTo(MoscowMetroStations metroStations) {
        return this.stationName.compareTo(metroStations.getStationName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(stationName, numberMetroLines);
    }
}
