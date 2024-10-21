package ru.svanchukov.tomcat.myservletsproject.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDto {
    Long id;
    String email;
}
