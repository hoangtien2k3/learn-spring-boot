
## CORS (Cross-Origin Resource Sharing) : trong Spring Boot
- Chính sách Cross-Origin Resource Sharing (CORS) là một cơ chế bảo mật mà trình duyệt thực hiện để kiểm soát truy cập từ các nguồn khác nhau trên web. 
- Khi một trang web hoặc ứng dụng web cố gắng gửi yêu cầu HTTP đến một nguồn gốc khác `(ví dụ: từ một trang web tới một máy chủ API), trình duyệt sẽ kiểm tra chính sách CORS để quyết định xem yêu cầu có được phép hoặc không.`


### Thiết lập CORS trong controller method
- CORS rất đơn giản – chỉ cần thêm annotation `@CrossOrigin`.

`@CrossOrigin` trong phương thức được đánh dấu `@RequestMapping`
```java 
@RestController
@RequestMapping("/account")
public class AccountController {

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/{id}") // hoặc viết ngắn hơn @GetMapping("/{id}")
    public Account retrieve(@PathVariable Long id) {
        // ...
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void remove(@PathVariable Long id) {
        // ...
    }
}
```

- Cho phép truy cập từ mọi origin
- Hàm HTTP request được phép truy cập được là hàm được nhắc đến bên trong annotation @RequestMapping (trong ví dụ này là GET)
- Thời gian truy vấn preflight phản hồi được cache (maxAge) là 30 phút.


##  @CrossOrigin trong Controller
```java
@CrossOrigin(origins = "http://example.com", maxAge = 3600)
@RestController
@RequestMapping("/account")
public class AccountController {

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Account retrieve(@PathVariable Long id) {
        // ...
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void remove(@PathVariable Long id) {
        // ...
    }
}
```

- @CrossOrigin vào cấp Class. Do vậy, cả phương thức retrieve() và remove() đều cho phép CORS. 


## @CrossOrigin cho cả class và phương thức của controller
```java
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/account")
public class AccountController {

    @CrossOrigin("http://example.com") // chỉ cho phép trang web này truy cập vào APIs
    @RequestMapping(method = RequestMethod.GET, "/{id}")
    public Account retrieve(@PathVariable Long id) {
        // ...
    }

    // Cho phép tất cả trang web truy cập vào APIs này.
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void remove(@PathVariable Long id) {
        // ...
    }
}
```





