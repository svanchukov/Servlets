package ru.svanchukov.tomcat.myservletsproject.service;

import ru.svanchukov.tomcat.myservletsproject.dao.UserDao;
import ru.svanchukov.tomcat.myservletsproject.entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AdminService {
    private static final AdminService INSTANCE = new AdminService();
    private final UserDao userDao = UserDao.getInstance();

    public static AdminService getInstance() {
        return INSTANCE;
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userDao.findById(id);
    }

    public boolean deleteUser(Integer id) {
        return userDao.delete(id);
    }

    public User saveUser(User user) throws SQLException {
        return userDao.save(user);
    }

    public void updateUser(User user) {
        userDao.update(user);
    }
}
