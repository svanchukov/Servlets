package service;

import com.svanchukov.http.server.dao.FlightDao;
import com.svanchukov.http.server.entity.Flight;
import dto.FlightDto;

import java.util.List;
import java.util.stream.Collectors;

public class FlightService {

    private final FlightDao flightDao = FlightDao.getINSTANCE();

    private static final FlightService INSTANCE = new FlightService();

    private FlightService() {
    }

    public static FlightService getInstance() {
        return INSTANCE;
    }

    public List<FlightDto> findAll() {
        List<Flight> flights = flightDao.findAll();
        System.out.println("Flights from DAO: " + flights); // Добавьте логирование
        return flights.stream()
                .map(flight -> new FlightDto(
                        flight.getId(),
                        """
                                %s - %s - %s
                                """.formatted(flight.getDepartureAirportCode(), flight.getArrivalAirportCode(), flight.getStatus())
                ))
                .collect(Collectors.toList());
    }

}
