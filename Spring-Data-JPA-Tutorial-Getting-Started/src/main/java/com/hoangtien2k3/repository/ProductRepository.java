package com.hoangtien2k3.repository;

import com.hoangtien2k3.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
}