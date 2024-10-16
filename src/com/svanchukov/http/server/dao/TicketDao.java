package com.svanchukov.http.server.dao;

import com.svanchukov.http.server.entity.FlightStatus;
import com.svanchukov.http.server.entity.Ticket;
import com.svanchukov.http.server.util.ConnectionManager;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDao implements Dao<Long, Ticket>{

    private static final TicketDao INSTANCE = new TicketDao();

    private static final String FIND_ALL_BY_FLIGHT_ID = """
    SELECT *
    FROM ticket\s
    WHERE flight_id = ?
""";

    private TicketDao() {
    }

    public static TicketDao getInstance() {
        return INSTANCE;
    }

    public List<Ticket> findAllByFlightId(Long flightId) {
        try (var connection = ConnectionManager.get();
        var preparedStatement = connection.prepareStatement(FIND_ALL_BY_FLIGHT_ID)) {
            preparedStatement.setObject(1, flightId);

            var resultSet = preparedStatement.executeQuery();
            List<Ticket> tickets = new ArrayList<>();
            while (resultSet.next()) {
                tickets.add(buildTicket(resultSet));
            }

            return tickets;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    private Ticket buildTicket(ResultSet resultSet) throws SQLException {
        return new Ticket(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("passenger_no", String.class),
                resultSet.getObject("passenger_name", String.class),
                resultSet.getObject("flight_id", Long.class),
                resultSet.getObject("seat_no", String.class),
                resultSet.getObject("cost", BigDecimal.class)
        );
    }

    @Override
    public List<Ticket> findAll() {
        return List.of();
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(Ticket entity) {

    }

    @Override
    public Ticket save(Ticket entity) {
        return null;
    }
}
