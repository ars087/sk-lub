package jsonPars;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class StationsDepth implements Comparable<StationsDepth> {
    private String stationName;
    private String depth;

    @JsonCreator
    public StationsDepth(
            @JsonProperty("station_name") String station_name,
            @JsonProperty("depth") String depth
    ) {
        this.stationName = StringUtils.stripAccents(station_name);
        this.depth =depthValidation( depth);
    }


    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

//    @Override
//    public boolean equals(Object obj) {
//
//        StationsDepth stationsDepth = (StationsDepth) obj;
//        if (this.getStationName().equals(stationsDepth.getStationName())) {
//
//
//            return compareTo(stationsDepth) == 0;
//        }
//
//        return false;
//    }

    @Override
    public int compareTo(StationsDepth stationsDepth) {
//
//        if ((this.getStationName().compareTo(stationsDepth.getStationName())) == 0) {
//
//
//            return this.getDepth().compareTo(stationsDepth.getDepth());
//
//
//        }


        return this.getStationName().compareTo(stationsDepth.getStationName());


    }


    @Override
    public String toString() {
        return getStationName() + "" + getDepth();
    }

    public String depthValidation(String depth) {

        String regEx = "(\\Q-\\E)*\\d+(\\Q,\\E)*\\d*+";

        if (!depth.matches(regEx)) {
            return null;

        }

        return depth;
    }

}

