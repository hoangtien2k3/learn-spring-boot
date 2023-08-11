package com.springbootlearning.springbootthymeleafjpahibernatemysql.controllers;

import com.springbootlearning.springbootthymeleafjpahibernatemysql.domain.User;
import com.springbootlearning.springbootthymeleafjpahibernatemysql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }


}
