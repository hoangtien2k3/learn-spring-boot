package com.hoangtien2k3.SpringBootDTOValidationExample.controller;

import com.hoangtien2k3.SpringBootDTOValidationExample.dto.UserDto;
import com.hoangtien2k3.SpringBootDTOValidationExample.model.User;
import com.hoangtien2k3.SpringBootDTOValidationExample.service.UserService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("users")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){

        // convert UserDto to User entity
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        User savedUser = userService.createUser(user);

        // convert User entity to UserDto class
        UserDto userResponse = new UserDto();
        userResponse.setId(savedUser.getId());
        userResponse.setName(savedUser.getName());
        userResponse.setEmail(savedUser.getEmail());
        // don't provide password to client
        // userResponse.setPassword(savedUser.getPassword());

        return new ResponseEntity<UserDto>(userResponse, HttpStatus.CREATED);
    }
}