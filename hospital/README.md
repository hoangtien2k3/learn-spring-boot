## TEST API - POST - GET - PUT

## POST : register
![Screenshot 2023-05-12 170020](https://github.com/hoangtien2k3qx1/learn-spring-boot/assets/122768076/963363a4-4ee6-46e2-9800-a270797a80cf)
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
![Screenshot 2023-05-12 224157](https://github.com/hoangtien2k3qx1/learn-spring-boot/assets/122768076/09de2d39-cdc6-4986-8520-48ca180e6510)

![Screenshot 2023-05-12 224045](https://github.com/hoangtien2k3qx1/learn-spring-boot/assets/122768076/c3ab0ebc-6e08-4a11-8fdf-5df65b987b44)
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
![Screenshot 2023-05-12 174352](https://github.com/hoangtien2k3qx1/learn-spring-boot/assets/122768076/ab8ea7c9-83c7-42c9-b313-b00a9d7e361b)
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


## GET : all
![Screenshot 2023-05-12 174335](https://github.com/hoangtien2k3qx1/learn-spring-boot/assets/122768076/3f48695e-59da-4639-b612-c487d2624b9f)
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


## GET : detailProduct
![Screenshot 2023-05-12 220032](https://github.com/hoangtien2k3qx1/learn-spring-boot/assets/122768076/f5a94821-f541-430f-ad4e-b7ccf7d93815)
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





























