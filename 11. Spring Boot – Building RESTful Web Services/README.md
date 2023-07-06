
## 11. Spring Boot – Building RESTful Web Services


### Rest Controller
```java
@RestController
public class ProductServiceController {
}
```
### Request Mapping
```java
@RequestMapping(value="/products")
public ResponseEntity<Object> getProducts() { }
```

### Request Body
```java
public ResponseEntity<Object> createProduct(@RequestBody Product product) {
}
```

