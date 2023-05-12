
## POST : register
```java
@PostMapping(path = "/register") // POST:  http://localhost:8081/users/register/
    public @ResponseBody Hashtable registerUser(@RequestParam String name,
                                                @RequestParam String email,
                                                @RequestParam String userType,
                                                @RequestParam String password) {

        Hashtable<String, Object> response = new Hashtable<>();
        // check dublicate email user
        List<UserRepository.User> foundUsers = userRepository.findByEmail(email);
        if (foundUsers.size() > 0) {
            if (userType.equals("facebook")) {
                response.put("result", "oke");
                response.put("data", foundUsers.get(0));
                response.put("message", "Login user successfully");
                return response;
            } else {
                response.put("result", "failed");
                response.put("data", "");
                response.put("message", "User already exists");
                return response;
            }
        }

        User newUser = new User(name, email, userType, password);
        userRepository.save(newUser); // insert into database mysql
        response.put("result", "oke");
        response.put("data", newUser);
        response.put("message", "Register user Successfully");
        return response;
    }
```


## POST : login
```java
@PostMapping(path = "/login") // GET:  http://localhost:8081/users/login/
    public @ResponseBody Hashtable login(@RequestParam String email,
                                         @RequestParam String password,
                                         @RequestParam String userType)  {
        Hashtable<String, Object> response = new Hashtable<>();
        try {
            if (userType.equals("facebook")) {
                List<UserRepository.User> foundUsers = userRepository.findByEmail(email);
                if (foundUsers.size() > 0) {
                    response.put("result", "oke");
                    response.put("data", foundUsers.get(0));
                    response.put("message", "Login user successfully");
                } else {
                    response.put("result", "failed");
                    response.put("data", "");
                    response.put("message", "Cannot find user");
                }
            } else {
                UserRepository.User foundUser = userRepository.findByEmailAndPassword(email, password);
                response.put("result", "oke");
                response.put("data", foundUser);
                response.put("message", "Login user successfully");
            }
        } catch(NoSuchElementException e) {
            response.put("result", "failed");
            response.put("data", "");
            response.put("message", "Cannot find user: Error" + e);
        } finally {
            return response;
        }
    }
```


## POST : add
```java
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
```


## GET : add
```java
@GetMapping(path = "/all") // GET:  http://localhost:8081/products/all/
    public @ResponseBody Hashtable getAllProducts(@RequestParam Integer userId) {
        Hashtable<String, Object> response = new Hashtable<>();
        List<ProductRepository.Product> products = productRepository.findByUserId(userId);
        response.put("result", "oke");
        response.put("data", products);
        response.put("message", "Query product successfully");
        return response;
    }
```


## 
```java
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
```





























