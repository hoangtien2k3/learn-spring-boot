package com.hoangtien2k3.springbootSearchRESTAPIJpaMysql.service.impl;

import com.hoangtien2k3.springbootSearchRESTAPIJpaMysql.entity.Product;
import com.hoangtien2k3.springbootSearchRESTAPIJpaMysql.repository.ProductRepository;
import com.hoangtien2k3.springbootSearchRESTAPIJpaMysql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> searchProducts(String query) {
        List<Product> products = productRepository.searchProducts(query);
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}