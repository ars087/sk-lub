import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoutCalculatorTest extends TestCase {

    List<Station> route;
    List<Station> stations;
    List<Station> stationsTwo;

    StationIndex stationIndex;
    RouteCalculator routeCalculator;

    Station stationSuzuki;
    Station stationToyota;
    Station stationMazda;
    Station stationHonda;

    Station stationMaserati;
    Station stationFerrari;
    Station stationFiat;
    Station stationLamborghini;

    Station stationFord;
    Station stationDodge;
    Station stationCadillac;
    Station stationTesla;

    Line line1;
    Line line2;
    Line line3;


    @Override

    protected void setUp() throws Exception {
        route = new ArrayList<>();
        stations = new ArrayList<>();
        stationsTwo = new ArrayList<>();

        line1 = new Line(1, "Красная");
        line2 = new Line(2, "Зеленая");
        line3 = new Line(3, "Синяя");


        stationToyota = new Station("Тоёта", line1);
        stationSuzuki = new Station("Сузуки", line1);
        stationMazda = new Station("Мазда", line1);
        stationHonda = new Station("Хонда", line1);

        stationMaserati = new Station("Мазерати", line2);
        stationFerrari = new Station("Феррари", line2);
        stationFiat = new Station("Фиат", line2);
        stationLamborghini = new Station("Ламборджини", line2);

        stationFord = new Station("Форд", line3);
        stationDodge = new Station("Додж", line3);
        stationCadillac = new Station("Кадилак", line3);
        stationTesla = new Station("Тесла", line3);


        stationIndex = new StationIndex();
        routeCalculator = new RouteCalculator(stationIndex);


        line1.addStation(stationHonda);
        line1.addStation(stationMazda);
        line1.addStation(stationSuzuki);
        line1.addStation(stationToyota);


        line2.addStation(stationLamborghini);
        line2.addStation(stationMaserati);
        line2.addStation(stationFerrari);
        line2.addStation(stationFiat);


        line3.addStation(stationFord);
        line3.addStation(stationDodge);
        line3.addStation(stationCadillac);
        line3.addStation(stationTesla);


        route.add(new Station("Станция1", line1));
        route.add(new Station("Станция2", line1));
        route.add(new Station("Станция3", line1));
        route.add(new Station("Станция4", line1));
        route.add(new Station("Станция второй линии", line2));
    }


    public void testGetShortestRouteOnTheLine() {


        List<Station> actual = routeCalculator.getShortestRoute(stationToyota, stationSuzuki);
        List<Station> expected = new ArrayList<>();

        expected.add(stationSuzuki);
        expected.add(stationToyota);

        Collections.reverse(expected);

        assertEquals(expected, actual);

    }

    public void testGetShortestRouteOneTheLine() {


        stations.add(stationSuzuki);
        stations.add(stationFiat);
        stationIndex.addConnection(stations);

        List<Station> actual = routeCalculator.getShortestRoute(stationHonda, stationLamborghini);
        List<Station> expected = new ArrayList<>();

        expected.add(stationHonda);
        expected.add(stationMazda);
        expected.add(stationSuzuki);

        expected.add(stationFiat);
        expected.add(stationFerrari);
        expected.add(stationMaserati);
        expected.add(stationLamborghini);

        assertEquals(expected, actual);

    }

    public void testGetShortestRouteTwoTheLine() {

        stations.add(stationSuzuki);
        stations.add(stationLamborghini);
        stationIndex.addConnection(stations);


        stationsTwo.add(stationCadillac);
        stationsTwo.add(stationFiat);

        stationIndex.addConnection(stationsTwo);

        List<Station> actual = routeCalculator.getShortestRoute(stationTesla, stationHonda);
        List<Station> expected = new ArrayList<>();

        expected.add(stationHonda);
        expected.add(stationMazda);
        expected.add(stationSuzuki);
        expected.add(stationLamborghini);
        expected.add(stationMaserati);
        expected.add(stationFerrari);
        expected.add(stationFiat);
        expected.add(stationCadillac);
        expected.add(stationTesla);

        Collections.reverse(expected);

        assertEquals(expected, actual);


    }


    public void testCalculateDuration() {

        double actual = RouteCalculator.calculateDuration(route);
        double expected = 11;
        assertEquals(expected, actual);

    }


    @Override
    protected void tearDown() throws Exception {

    }
}
