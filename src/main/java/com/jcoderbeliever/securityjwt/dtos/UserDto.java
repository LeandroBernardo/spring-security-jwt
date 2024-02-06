package com.jcoderbeliever.securityjwt.dtos;

public record UserDto(
        String name,
        String login,
        String password
) {
}
