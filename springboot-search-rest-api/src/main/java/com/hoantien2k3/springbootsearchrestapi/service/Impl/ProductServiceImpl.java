package com.hoantien2k3.springbootsearchrestapi.service.Impl;

import com.hoantien2k3.springbootsearchrestapi.entity.Product;
import com.hoantien2k3.springbootsearchrestapi.repository.ProductRepository;
import com.hoantien2k3.springbootsearchrestapi.service.ProductService;
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
        List<Product> products = productRepository.searchProductsSQL(query);
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
