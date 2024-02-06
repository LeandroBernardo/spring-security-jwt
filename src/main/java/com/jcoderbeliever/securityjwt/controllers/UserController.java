package com.jcoderbeliever.securityjwt.controllers;

import com.jcoderbeliever.securityjwt.dtos.UserDto;
import com.jcoderbeliever.securityjwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    private UserDto save(@RequestBody UserDto userDto) {

        return userService.save(userDto);
    }
}
