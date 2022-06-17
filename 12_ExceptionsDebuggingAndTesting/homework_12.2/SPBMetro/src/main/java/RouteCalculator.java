import core.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class RouteCalculator {
    private final StationIndex stationIndex;

    private static final double INTER_STATION_DURATION = 2.5;
    private static final double INTER_CONNECTION_DURATION = 3.5;

    public RouteCalculator(StationIndex stationIndex) {
        this.stationIndex = stationIndex;
    }

    public List<Station> getShortestRoute(Station from, Station to) {
        List<Station> route = getRouteOnTheLine(from, to);//1
        if (route != null) {
            return route;
        }

        route = getRouteWithOneConnection(from, to);//2
        if (route != null) {
            return route;
        }

        route = getRouteWithTwoConnections(from, to);//3
        return route;
    }

    public static double calculateDuration(List<Station> route) {
        double duration = 0;
        Station previousStation = null;

        for (int i = 0; i < route.size(); i++) {

            Station station = route.get(i);

            if (i > 0) {

                duration += previousStation.getLine().equals(station.getLine()) ?
                        INTER_STATION_DURATION : INTER_CONNECTION_DURATION;
            }
            previousStation = station;
        }
        return duration;
    }

    private List<Station> getRouteOnTheLine(Station from, Station to) { //1
        if (!from.getLine().equals(to.getLine())) {
            return null;
        }

        List<Station> route = new ArrayList<>();
        List<Station> stations = from.getLine().getStations();
        int direction = 0;
        for (Station station : stations) {
            if (direction == 0) {
                if (station.equals(from)) {
                    direction = 1;
                } else if (station.equals(to)) {
                    direction = -1;
                }
            }

            if (direction != 0) {
                route.add(station);
            }

            if ((direction == 1 && station.equals(to)) ||
                    (direction == -1 && station.equals(from))) {
                break;
            }
        }//цикл
        if (direction == -1) {
            Collections.reverse(route);
        }
        return route;
    }

    private List<Station> getRouteWithOneConnection(Station from, Station to) {  //2
        if (from.getLine().equals(to.getLine())) {
            return null;
        }
        List<Station> route = new ArrayList<>();
        List<Station> fromLineStations = from.getLine().getStations();
        List<Station> toLineStations = to.getLine().getStations();

        for (Station srcStation : fromLineStations) {

            for (Station dstStation : toLineStations) {

                if (isConnected(srcStation, dstStation)) {
                    ArrayList<Station> way = new ArrayList<>();
                    way.addAll(getRouteOnTheLine(from, srcStation));
                    way.addAll(getRouteOnTheLine(dstStation, to));

                    route.addAll(way);
                    return route;


                }

            }//2
        }

        return null;
    }

    private boolean isConnected(Station station1, Station station2) { //вызывается во втором
        Set<Station> connected = stationIndex.getConnectedStations(station1);
        return connected.contains(station2);
    }

    private List<Station> getRouteViaConnectedLine(Station from, Station to) { //вызывается в третьем методе
        Set<Station> fromConnected = stationIndex.getConnectedStations(from);
        Set<Station> toConnected = stationIndex.getConnectedStations(to);
        for (Station srcStation : fromConnected) {
            for (Station dstStation : toConnected) {
                if (srcStation.getLine().equals(dstStation.getLine())) {
                    return getRouteOnTheLine(srcStation, dstStation);
                }
            }
        }
        return null;
    }

    private List<Station> getRouteWithTwoConnections(Station from, Station to) { //3
        if (from.getLine().equals(to.getLine())) {
            return null;
        }

        ArrayList<Station> route = new ArrayList<>();

        List<Station> fromLineStations = from.getLine().getStations();
        List<Station> toLineStations = to.getLine().getStations();

        for (Station srcStation : fromLineStations) {
            for (Station dstStation : toLineStations) {
                List<Station> connectedLineRoute =
                        getRouteViaConnectedLine(srcStation, dstStation);
                if (connectedLineRoute == null) {
                    continue;
                }
                List<Station> way = new ArrayList<>();
                way.addAll(getRouteOnTheLine(from, srcStation));
                way.addAll(connectedLineRoute);
                way.addAll(getRouteOnTheLine(dstStation, to));
                route.addAll(way);
                return route;

            }
        }

        return null;
    }
}