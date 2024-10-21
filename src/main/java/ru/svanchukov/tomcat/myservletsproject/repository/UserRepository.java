package ru.svanchukov.tomcat.myservletsproject.repository;

import ru.svanchukov.tomcat.myservletsproject.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList<>();
    private int nextId = 1;

    public UserRepository() {
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void deleteUser(Integer id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    public Integer save(User user) {
        user.setId(nextId++);
        users.add(user);
        return user.getId();
    }
}
