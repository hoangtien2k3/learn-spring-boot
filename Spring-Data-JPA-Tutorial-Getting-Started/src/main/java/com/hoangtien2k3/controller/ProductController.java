package com.hoangtien2k3.controller;

import com.hoangtien2k3.service.ProductService;
import com.hoangtien2k3.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    // dẩy 1 sản phẩm vào cơ sở dữ liệu
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    // đẩy tất cả sản phẩm vào cơ sở dữ liệu mysql
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    // lấy ra danh sách tất cả sản phẩm trong sơ sở dữ liệu
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    // lấy ra thông tin sản phẩm theo Id
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
    // lấy ra thông tin sản phẩm theo tên
    public Product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    // cập nhật lại thông tin 1 sản phẩm
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    // xóa sản phẩm trog cơ sở dữ liệu mysql
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}