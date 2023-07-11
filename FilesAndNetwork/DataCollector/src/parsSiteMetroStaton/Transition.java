package parsSiteMetroStaton;

public class Transition {

    Transition(String lineNumber, String nameStation) {

        this.lineNumber = lineNumber;
        this.nameStation = nameStation;

    }

    String nameStation;
    String lineNumber;


    public String getNameStation() {
        return nameStation;
    }

    public void setNameStation(String nameStation) {
        this.nameStation = nameStation;
    }

    public String getLineNumber() {
        return nameStation;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }


}
