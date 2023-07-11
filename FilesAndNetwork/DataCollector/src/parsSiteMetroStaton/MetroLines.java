package parsSiteMetroStaton;

import java.util.*;

public class MetroLines {

    MetroLines(String nameLines, String numberLine) {

        this.nameLines = nameLines;
        this.numberLine = numberLine;
    }

    String nameLines;
    String numberLine;

     public String getNameLines() {
        return nameLines;
    }

    public void setNameLines(String nameLines) {
        this.nameLines = nameLines;
    }

    public String getNumberLine() {
        return numberLine;
    }

    public void setNumberLine(String numberLine) {
        this.numberLine = numberLine;
    }


    @Override
    public String toString() {
        return numberLine + " " + nameLines;
    }
}








