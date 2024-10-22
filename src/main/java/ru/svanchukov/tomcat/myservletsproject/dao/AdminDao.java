package ru.svanchukov.tomcat.myservletsproject.dao;

import ru.svanchukov.tomcat.myservletsproject.entity.User;
import ru.svanchukov.tomcat.myservletsproject.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AdminDao implements Dao<Integer, User>{

    private static final String DELETE_BY_ID = """
            DELETE FROM users 
            WHERE id = ?
            """;

    public static boolean deleteById(Connection connection, int userId) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, userId);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        try (Connection connection = ConnectionManager.get()) {
            return deleteById(connection, id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public User save(User entity) throws SQLException {
        return null;
    }
}
