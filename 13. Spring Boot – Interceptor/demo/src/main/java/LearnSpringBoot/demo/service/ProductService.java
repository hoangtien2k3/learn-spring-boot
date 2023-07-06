package LearnSpringBoot.demo.service;

import LearnSpringBoot.demo.entity.Product;

import java.util.Collection;

public interface ProductService {
    public abstract void createProduct(Product product);
    public abstract void updateProduct(String id, Product product);
    public abstract void deleteProduct(String id);
    public abstract Collection<Product> getProducts(); // hàm ảo định nghĩa(lấy tất cả thông tin) và trả về Collection
}
