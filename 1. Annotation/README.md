
## Spring Boot Annotations 

#### Core Spring Framework Annotations

[@Required](): nó được áp dụng cho phương thức setter method. Nó chỉ ra rằng Bean được chú thích phải điền vào thời điểm cấu hình, nếu không thì nó sẽ ném ra ngoại lên 'BeanInitilizationException'
```java
public class Machine {  
    private Integer cost;  
    @Required  
    public void setCost(Integer cost) {  
        this.cost = cost;  
    }  
    public Integer getCost() {  
        return cost;  
    }     
}  
```


[@Autowired](): nó được sử dụng để tiêm(inject) đối tượng vào các phương thức 'setter', 'instance variable' và 'constructor'. @Autowired, bộ chứa lò xo sẽ tự động kết nối bean bằng cách khớp loại dữ liệu.
```java
@Component  
public class Customer {  
    private Person person;  
    
    @Autowired  
    public Customer(Person person) {   
        this.person=person;  
    }  
}  
```


[@Configuration](): Nó là một chú thích cấp bậc.Lớp được chú thích '@Configuration' sử dụng làm nguồn định nghĩa 'Bean'
```java
@Configuration  
public class Vehicle {  
    
    @BeanVehicle engine() {  
        return new Vehicle();  
    }  
}  
```


[@ComponentScan](): Nó được sử dụng khi chúng ta muốn qquyets một package từ beans. Nó được sử dụng với annotation '@Configuration'
```java
@ComponentScan(basePackages = "com.javatpoint")  
@Configuration  
public class ScanComponent {  
    // ...  
}
```


[@Bean](): Nó là mộ chút thích 'method' cấp bậc. Nó là một sự thay thế của thẻ <bean> XML. Nó cho biết phương thưức tạo ra một Bean được quản lý bởi Spring Container
```java
@Bean  
public BeanExample beanExample() {  
    return new BeanExample ();  
}  
```


## Các mẫu Spring Boot Annotations:

[@Component]() : Nó là một chú thích 'class' cấp bậc. Nó được sử dụng để đánh dấu lớp(class) là một Bean.
```java
@Component  
public class Student {  
    .......  
}  
```


[@Controller](): Nó là chú thích 'class' cấp bậc. Nó tương đương với '@Component'. Nó chủ yếu được sử dụng với chú thích '@RequestMapping'.
```java
@Controller  
@RequestMapping("books")  
public class BooksController {  
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)  
    public Employee getBooksByName() {  
        return booksTemplate;  
    }  
}  
```


[@Service]() : Nó là chú thích 'class' cấp bậc. Nó đánh dấu class chứ các Logic nghiệp vụ
```java
package com.javatpoint;  
@Service  
public class TestService {  
    public void service1() {  
        //business code  
    }  
}  
```


[@Repository](): Nó là chú thích 'class' cấp bậc. Kho lưu trữ là một DAO(Data Access Object) nơi truy cập trực tiếp vao cơ sở dữ liệu. Kho lưu trữ thực hiện tất cả hoạt động liên quan tới Cơ sở dữ liệu.
```java
package com.javatpoint;  
@Repository   
public class TestRepository {  
    public void delete() {     
        //persistence code  
    }  
}  
```

## Spring Boot Annotations:

[@EnableAutoConfiguration]() : Nó tự động cấu hình Bean trong đường dẫn lớp và định cấu hình nó để chạy chương trình. Nó đã cũ và được thay thế bởi '@SpringBootApplication'.

[@SpringBootApplication]() : Nó là sự kết hợp của 3 chú thích: + @EnableAutoConfiguration, + @ComponentScan, + @Configuration.

[@ComponentScan]() : 
[@Configuration]() :



## Spring MVC and REST Annotations:

[@RequestMapping]() : Nó được sử dụng để ánh xạ các yêu cầu web. Nó thì có nhiêu optional elements như: consumes, header, method, name, params, path, produces, and value. 
```java
@Controller  
public class BooksController {  
@RequestMapping("/computer-science/books")  
public String getAllBooks(Model model) {  
    //application code  
    return "bookList";  
}  
```


[@GetMapping]() : Nó ánh xạ các yêu cầu HTTP GET trên phương thức xử lý cụ thể. Nó sử dụng để tạo ra web service endpoint để fetches , nó được tạo và sử dụng '@RequestMapping(method = RequestMethod.GET)'
- Lưu ý: `@RequestMapping(method = RequestMethod.GET)` và `@GetMapping` là tương đương nhau, tuy nhiên để làm mã nguồn trở nên ngắn gọn và dễ đọc, nên ưu tiên sử dụng `@GetMapping`

```java
@GetMapping("/users")
public List<User> getUsers() {
    // code xử lý yêu cầu GET
}

//////////////////////////////////
@RequestMapping(value = "/users", method = RequestMethod.GET)
public List<User> getUsers() {
    // code xử lý yêu cầu GET
}
```


[@PostMapping](): Nó ánh xạ các yêu cầu HTTP POST để tạo web service endpoint. Nó được sử dụng thay vì sử dụng '@RequestMapping(method = RequestMethod.POST)'
```java
@PostMapping("/users")
public User createUser(@RequestBody User user) {
    // code xử lý yêu cầu POST
}
```

[@PutMapping](): Nó ánh xạ các yêu cầu HTTP PUT trên phương thức xử lý cụ thể. Nó được sử dụng để tạo web service endpoint hoặc updates. Nó được sử dụng thay vì sử dụng '@RequestMapping(method = RequestMethod.PUT)'
```java
@PutMapping("/users/{id}")
public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
    // code xử lý yêu cầu PUT để cập nhật thông tin user với id tương ứng
}
```


[@DeleteMapping](): Nó ánh xạ các yêu cầu XÓA HTTP trên phương thức xử lý cụ thể. Nó được sử dụng để tạo a web service endpoint that deletes. Nó được sử dụng thay vì sử dụng '@RequestMapping(method = RequestMethod.DELETE)'
```java
@DeleteMapping("/users/{id}")
public void deleteUser(@PathVariable("id") Long id) {
    // code xử lý yêu cầu DELETE để xóa user với id tương ứng
}
```


[@PatchMapping](): Nó ánh xạ các yêu cầu HTTP PATCH trên phương thức xử lý cụ thể. Nó được sử dụng thay vì sử dụng '@RequestMapping(method = RequestMethod.PATCH)'
```java
@PatchMapping("/users/{id}")
public User updateUserPartial(@PathVariable("id") Long id, @RequestBody User user) {
    // code xử lý yêu cầu PATCH để cập nhật một số thuộc tính của user với id tương ứng
}
```


[@RequestBody](): Nó được sử dụng trong Spring để đánh dấu một tham số phương thức. Nó cho phép Spring biết rằng giá trị của tham số được truyền vào phương thức thông qua thân request của yêu cầu HTTP.
```java
@PostMapping("/users")
public User createUser(@RequestBody User user) {
    // code xử lý yêu cầu POST để thêm user mới
}
```


[@ResponseBody](): Nó liên kết giá trị trả về của phương thức với nội dung phản hồi. Nó yêu cầu Spring Boot Framework tuần tự hóa trả về một đối tượng thành định dạng JSON và XML.
```java
@GetMapping("/users")
@ResponseBody
public List<User> getUsers() {
    List<User> users = userService.getUsers();
    return users;
}
```

[@PathVariable](): 

[@RequestParam]():

[@RequestHeader]():

[@RestController]():

[@RequestAttribute](): 









