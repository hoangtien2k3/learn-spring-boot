package com.tutorial.apidemo.Springboottutorial.controllers;


import com.tutorial.apidemo.Springboottutorial.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Products")
public class ProductController {
    // DI = Dependency Injection
//    @Autowired
//    private ProductRepository repository;

    @GetMapping("")
    // this request is: http://localhost:8080/api/v1/Products
    List<Product> getAllProducts() {
        List<Product> listProduct = new ArrayList<>();
        listProduct.add(new Product(1L, "Macbook pro 2023", 2023, 2400.0, ""));
        listProduct.add(new Product(2L, "Macbook pro 2023", 2023, 2400.0, ""));

        return listProduct;
//        return repository.findAll(); // where is data ?
    }

    // you must save this to Database, now we have H2 = in-memory database
    // you can also send request using postman
}
