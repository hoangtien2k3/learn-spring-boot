package HospitalManagementJDBC.controller;

import HospitalManagementJDBC.product.Product;
import HospitalManagementJDBC.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import HospitalManagementJDBC.product.Product;

import java.util.Hashtable;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping(path = "/products")  // http://localhost:8081/products/
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping(path = "/add") // POST:  http://localhost:8081/products/add/
    public @ResponseBody Hashtable registerUser(@RequestParam String productName,
                                                @RequestParam Integer productYear,
                                                @RequestParam Double price,
                                                @RequestParam String productDescription,
                                                @RequestParam Integer userId
                                                )
    {
        Hashtable<String, Object> response = new Hashtable<>();
        Product newProduct = new Product(productName, productYear, price, productDescription, userId);
        productRepository.save(newProduct); // insert data in table product
        response.put("result", "oke");
        response.put("data", newProduct);
        response.put("message", "Add new product successfully");
        return response;
    }

    // Get information product
    @GetMapping(path = "/all") // GET:  http://localhost:8081/products/all/
    public @ResponseBody Hashtable getAllProducts(@RequestParam Integer userId) {
        Hashtable<String, Object> response = new Hashtable<>();
        List<ProductRepository.Product> products = productRepository.findByUserId(userId);
        response.put("result", "oke");
        response.put("data", products);
        response.put("message", "Query product successfully");
        return response;
    }


    // get detail information product
    @GetMapping(path = "/detailProduct") // GET:  http://localhost:8081/products/detailProduct/
    public @ResponseBody Hashtable getDetailProduct(@RequestParam Integer id)  {
        Hashtable<String, Object> response = new Hashtable<>();
        try {
            Product detailProduct = productRepository.findById(id).get();
            response.put("result", "oke");
            response.put("data", detailProduct);
            response.put("message", "Query product successfully");
        } catch(NoSuchElementException e) {
            response.put("result", "failed");
            response.put("data", "");
            response.put("message", "Cannot find product with id = " + id);
        } finally {
            return response;
        }
    }

}
