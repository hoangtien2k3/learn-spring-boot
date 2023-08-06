package com.hoantien2k3.springbootsearchrestapi.service;

import com.hoantien2k3.springbootsearchrestapi.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> searchProducts(String query);

    Product createProduct(Product product);
}
