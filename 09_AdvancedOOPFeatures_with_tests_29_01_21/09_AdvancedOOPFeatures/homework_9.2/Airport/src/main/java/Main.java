import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        Airport airport = Airport.getInstance();

        findPlanesLeavingInTheNextTwoHours(airport).forEach(System.out::println);

    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {

        long twoHours = 7200000;

        Date dateNow = new Date(System.currentTimeMillis());
        Date lastTwoHours = new Date(System.currentTimeMillis() + twoHours);


        return airport.getTerminals().stream().map(Terminal::getFlights)
                .flatMap(Collection::stream)

                .filter(flight -> flight.getDate().getTime() <= lastTwoHours.getTime() && flight.getDate().getTime() >= dateNow.getTime())

                .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))

                .collect(Collectors.toList());
    }
}

