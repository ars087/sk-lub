import com.fasterxml.jackson.annotation.JsonInclude;
import org.antlr.v4.runtime.atn.Transition;
import parsSiteMetroStaton.MetroLines;
import parsSiteMetroStaton.MoscowMetroStations;

import java.util.*;

public class StationsLineTransition {


    public StationsLineTransition(Map<String,List<String>> linesAndStationsListMap, List<List<MoscowMetroStations>> transitions, Set<MetroLines> metroLines) {

        this.linesAndStationsListMap = linesAndStationsListMap;
        this.transitions = transitions;
        this.metroLines = metroLines;

    }

    Map<String,List <String>> linesAndStationsListMap;

    List<List<MoscowMetroStations>> transitions;
    Set<MetroLines> metroLines;

    public Map<String,List<String>> getLinesAndStationsListMap() {
        return linesAndStationsListMap;
    }

    public void setLinesAndStationsListMap(String key,String value ) {
        this.linesAndStationsListMap = linesAndStationsListMap;
    }

    public List<List<MoscowMetroStations>> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<List<MoscowMetroStations>> transitions) {
        this.transitions = transitions;
    }


    public Set<MetroLines> getMetroLines() {
        return metroLines;
    }

    public void setMetroLines(Set<MetroLines> metroLines) {
        this.metroLines = metroLines;
    }


}


