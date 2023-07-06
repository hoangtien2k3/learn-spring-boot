
## 8. Spring Boot – Runners

### Hoạt động của [Application Runner]() trong spring boot

- Trong Spring Boot, ApplicationRunner là một giao diện (interface) được sử dụng để thực thi mã sau khi ứng dụng Spring Boot đã khởi chạy hoàn toàn và trước khi nó bắt đầu nhận các yêu cầu từ người dùng. 
- Giao diện ApplicationRunner giúp bạn thực hiện các tác vụ khởi chạy hoặc cấu hình ban đầu cho ứng dụng của mình.


### Công Dụng của Application Runner trong Spring Boot:
1. Khởi chạy dữ liệu ban đầu: Bạn có thể sử dụng ApplicationRunner để thực hiện tác vụ khởi tạo dữ liệu ban đầu trong cơ sở dữ liệu. Ví dụ: tạo bảng, chèn dữ liệu mẫu, cấu hình môi trường, v.v.
2. Cấu hình hệ thống: ApplicationRunner cho phép bạn cấu hình các thông số và tùy chỉnh hệ thống trước khi ứng dụng chính bắt đầu hoạt động. Ví dụ: đặt các giá trị mặc định, cấu hình các tham số, tải cấu hình từ các nguồn khác nhau, v.v.
3. ...



Để sử dụng ApplicationRunner, bạn cần thực hiện các bước sau:

1. Tạo một lớp implement ApplicationRunner và triển khai phương thức run(). Ví dụ:
```java
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Thực hiện các tác vụ khởi chạy hoặc cấu hình ban đầu tại đây
    }
}
```

2. Trong lớp triển khai ApplicationRunner, bạn có thể sử dụng phương thức run() để thực hiện bất kỳ tác vụ nào cần thiết. 
```java
@Override
public void run(ApplicationArguments args) throws Exception {
    // Thực hiện các tác vụ khởi chạy hoặc cấu hình ban đầu tại đây
    System.out.println("Ứng dụng đã khởi chạy!");
    // ...
}
```

3. Khi ứng dụng Spring Boot được khởi động, ApplicationRunner sẽ tự động được gọi. Nó sẽ thực thi phương thức run() và bạn có thể thực hiện các tác vụ cần thiết để khởi chạy ứng dụng.




Example:
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.model.User;
import com.example.repository.UserRepository;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Kiểm tra xem có người dùng nào trong cơ sở dữ liệu chưa
        if (userRepository.count() == 0) {
            // Tạo người dùng mặc định
            User user = new User();
            user.setUsername("admin");
            user.setPassword("password");

            // Lưu người dùng vào cơ sở dữ liệu
            userRepository.save(user);

            System.out.println("Đã tạo người dùng mặc định.");
        }
    }
}
```



### IoC (Inversion of Control) chi là 2 loại Chính: 
+ Dependency Injection
+ Dependency Lookup.


## Sự giống và khác nhau @Controller và @RestController
Giống nhau:
- Cả @Controller và @RestController đều được sử dụng để xác định một lớp là một thành phần xử lý yêu cầu HTTP trong Spring Framework.
- Cả hai cho phép bạn xử lý yêu cầu và trả về kết quả phản hồi dưới dạng HTML, JSON hoặc các định dạng khác.

Khác nhau:
- @Controller được sử dụng khi bạn muốn xử lý yêu cầu HTTP và trả về kết quả phản hồi theo nhiều định dạng khác nhau, chẳng hạn như HTML, JSON, XML, v.v. 
- @RestController là một biến thể của @Controller và được sử dụng đặc biệt cho các ứng dụng RESTful. Nó kết hợp cả @Controller và @ResponseBody để tạo ra các phương thức xử lý yêu cầu HTTP và tự động chuyển đổi kết quả trả về thành định dạng JSON hoặc XML.


## [@PathVariable](): 








