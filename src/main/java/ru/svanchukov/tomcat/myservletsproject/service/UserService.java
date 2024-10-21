package ru.svanchukov.tomcat.myservletsproject.service;

import ru.svanchukov.tomcat.myservletsproject.dto.CreateUserDto;
import ru.svanchukov.tomcat.myservletsproject.entity.User;
import ru.svanchukov.tomcat.myservletsproject.repository.UserRepository;

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

    public static UserService getInstance() {
        return INSTANCE;
    }
}
