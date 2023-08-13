package com.hoangtien2k3.springboot.controller;

import com.hoangtien2k3.springboot.dto.UserLocationDTO;
import com.hoangtien2k3.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("users-location")
    public List<UserLocationDTO> getAllUsersLocation() {
        return userService.getAllUsersLocation();
    }


}
