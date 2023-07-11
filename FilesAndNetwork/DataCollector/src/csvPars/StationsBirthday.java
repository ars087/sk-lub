package csvPars;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.util.Objects;

public class StationsBirthday implements Comparable<StationsBirthday> {
    public String stationName;
    public LocalDate localDate;

    //    String pathToCsv;
    //  public int count;
    public StationsBirthday(String stationName, LocalDate dateOfCreation) {

        this.stationName = parsNameStation(stationName);
        this.localDate = dateOfCreation;
        // this.pathToCsv = pathToCsv;

    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public boolean equals(Object obj) {

        StationsBirthday stationsBirthday = (StationsBirthday) obj;
        return this.stationName.compareToIgnoreCase(stationsBirthday.getStationName()) == 0 && this.localDate.isEqual(stationsBirthday.getLocalDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(stationName, localDate);
    }

    @Override
    public String toString() {
        return getStationName() + " " + getLocalDate();
    }

    @Override
    public int compareTo(StationsBirthday o) {
        int i = this.stationName.compareToIgnoreCase(o.getStationName());
        if (i == 0) {
            return this.localDate.compareTo(o.getLocalDate());
        }

        return i;
    }

    public String parsNameStation(String stationName) {

        return StringUtils.stripAccents(stationName);
    }


}