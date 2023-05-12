package HospitalManagementJDBC.repository;

import HospitalManagementJDBC.product.Product;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;


public interface ProductRepository extends CrudRepository<Product, Integer> {
    // some query
    List<Product> findByUserId(Integer userId);

    @Entity // hibernate entity
    public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private String productName;
        private Integer productYear;
        private Double price;
        private String produtDescription;
        private Integer userId;

        public Product(String productName,
                       Integer productYear,
                       Double price,
                       String produtDescription,
                       Integer userId) {
            this.productName = productName;
            this.productYear = productYear;
            this.price = price;
            this.produtDescription = produtDescription;
            this.userId = userId;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public Integer getProductYear() {
            return productYear;
        }

        public void setProductYear(Integer productYear) {
            this.productYear = productYear;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public String getProdutDescription() {
            return produtDescription;
        }

        public void setProdutDescription(String produtDescription) {
            this.produtDescription = produtDescription;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }
    }
}
