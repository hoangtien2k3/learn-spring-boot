package com.hoangtien2k3.SpringBootDTOValidationExample.service;

import com.hoangtien2k3.SpringBootDTOValidationExample.model.User;
import com.hoangtien2k3.SpringBootDTOValidationExample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
