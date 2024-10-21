package ru.svanchukov.tomcat.myservletsproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String birthday;
    private String email;
    private String password;
    private String gender;
    private String role;
}
