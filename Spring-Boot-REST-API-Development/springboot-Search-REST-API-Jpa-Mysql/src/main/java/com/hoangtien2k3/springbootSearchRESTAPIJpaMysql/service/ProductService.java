package com.hoangtien2k3.springbootSearchRESTAPIJpaMysql.service;

import com.hoangtien2k3.springbootSearchRESTAPIJpaMysql.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> searchProducts(String query);

    Product createProduct(Product product);
}