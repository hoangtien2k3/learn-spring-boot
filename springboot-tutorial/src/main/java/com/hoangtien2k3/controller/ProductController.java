package com.hoangtien2k3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/product")
public class ProductController {
    @GetMapping("")
    public List<String> getAllProduct() {
        return List.of("apple", "api", "tien");
    }
}
