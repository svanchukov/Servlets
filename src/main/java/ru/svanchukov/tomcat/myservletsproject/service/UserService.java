package ru.svanchukov.tomcat.myservletsproject.service;

import ru.svanchukov.tomcat.myservletsproject.dto.CreateUserDto;
import ru.svanchukov.tomcat.myservletsproject.entity.User;
import ru.svanchukov.tomcat.myservletsproject.repository.UserRepository;

import java.util.Objects;

public class UserService {
    private static final UserService INSTANCE = new UserService();
    private final UserRepository userRepository = new UserRepository();

    public Integer create(CreateUserDto createUserDto) {
        User user = User.builder()
                .name(createUserDto.getName())
                .birthday(createUserDto.getBirthday())
                .email(createUserDto.getEmail())
                .password(createUserDto.getPassword())
                .gender(createUserDto.getGender())
                .role(createUserDto.getRole())
                .build();

        return userRepository.save(user);
    }

    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && Objects.equals(user.getPassword(), password)) {
            return true;
        }
        return false;
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
