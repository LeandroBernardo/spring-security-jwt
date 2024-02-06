package com.jcoderbeliever.securityjwt.services.impl;

import com.jcoderbeliever.securityjwt.dtos.UserDto;
import com.jcoderbeliever.securityjwt.models.User;
import com.jcoderbeliever.securityjwt.repositories.UserRepository;
import com.jcoderbeliever.securityjwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDto save(UserDto userDto) {

        User userAlreadyExists = userRepository.findByLogin(userDto.login());

        if(userAlreadyExists !=null) {
            throw new RuntimeException("User already exists");
        }

        User entity = new User(userDto.name(), userDto.login(), userDto.password());
        User newUser = userRepository.save(entity);

        return new UserDto(newUser.getName(), newUser.getLogin(), newUser.getPassword());
    }
}
