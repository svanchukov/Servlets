package com.svanchukov.http.server.dao;

import com.svanchukov.http.server.entity.Flight;
import com.svanchukov.http.server.entity.FlightStatus;
import com.svanchukov.http.server.util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Long, Flight> {

    private static final FlightDao INSTANCE = new FlightDao();

    private static final String FIND_ALL = """
            SELECT * 
            FROM flight
            """;

    private FlightDao() {
    }

    @Override
    public List<Flight> findAll() {
        List<Flight> flights = new ArrayList<>();
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL)) {
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                flights.add(buildFlight(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Добавьте логирование ошибок
            throw new RuntimeException(e);
        }
        System.out.println("Flights from DAO: " + flights); // Добавьте логирование
        return flights;
    }



    @Override
    public Optional<Flight> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(Flight entity) {
    }

    @Override
    public Flight save(Flight entity) {
        return null;
    }

    public static FlightDao getINSTANCE() {
        return INSTANCE;
    }

    private Flight buildFlight(ResultSet resultSet) throws SQLException {
        return new Flight(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("flight_no", String.class),
                resultSet.getObject("departure_date", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("departure_airport_code", String.class),
                resultSet.getObject("arrival_date", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("arrival_airport_code", String.class),
                resultSet.getObject("aircraft_id", Integer.class),
                FlightStatus.valueOf(resultSet.getObject("status", String.class))
        );
    }

}
