
## JUnit and Mockito

### JUnit:
- JUnit là một framework kiểm thử phổ biến trong Java, được sử dụng để viết và chạy các kiểm thử đơn vị và kiểm thử tích hợp.
- Để sử dụng JUnit trong Spring Boot, bạn cần thêm thư viện JUnit vào file cấu hình của dự án (pom.xml nếu sử dụng Maven hoặc build.gradle nếu sử dụng Gradle).
- dụng các annotation như `@Test`, `@BeforeEach`, `@AfterEach`, `@BeforeAll`, và `@AfterAll` để viết các phương thức kiểm thử và thiết lập môi trường.


Xác định phương thức kiểm thử
- `@Test`, `@BeforeEach`, `@AfterEach`, `@BeforeAll`, và `@AfterAll`

Tạo môi trường kiểm thử:
- `@BeforeEach`, `@BeforeAll`

Xác minh kết quả:
- `assertEquals`, `assertTrue`, `assertFalse`

Xử lý ngoại lệ:
- `@Test` kết hợp với `expected`
- `assertThrows`


### Mockito:
- Mockito là một thư viện mô phỏng (mocking) trong kiểm thử Java, được sử dụng để tạo ra các đối tượng giả lập (mock objects) để kiểm thử các tương tác giữa các thành phần.
- Spring Boot, Mockito thường được sử dụng để mô phỏng các phụ thuộc của các thành phần kiểm thử.
- 


[@ObjectMapper]()


[@BeforeEach]() :
- được sử dụng để thiết lập trạng thái ban đầu cho mỗi phương thức kiểm thử.
- Điều này giúp đảm bảo rằng mỗi phương thức kiểm thử được thực thi trong một môi trường đã được cài đặt sẵn, giúp tránh sự phụ thuộc giữa các phương thức kiểm thử và đảm bảo tính độc lập của chúng.

cài đặt maven: dependency JUnit vào file pom.xml
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.8.1</version>
    <scope>test</scope>
</dependency>
```

Ví dụ:
```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private Library library;

    @BeforeEach
    void setUp() {
        // Thiết lập trạng thái ban đầu trước mỗi phương thức kiểm thử
        library = new Library();
        library.addBook(new Book("Book 1", "Author 1"));
        library.addBook(new Book("Book 2", "Author 2"));
    }

    @Test
    void testAddBook() {
        int initialSize = library.getNumberOfBooks();
        
        // Thêm một cuốn sách mới
        library.addBook(new Book("New Book", "New Author"));
        
        assertEquals(initialSize + 1, library.getNumberOfBooks());
    }

    @Test
    void testRemoveBook() {
        int initialSize = library.getNumberOfBooks();

        // Xóa một cuốn sách
        library.removeBook("Book 1");

        assertEquals(initialSize - 1, library.getNumberOfBooks());
    }
}
```


## @AutoConfigureMockMvc
-  Khi bạn áp dụng annotation này trên một lớp kiểm thử (test class), Spring Boot sẽ cấu hình môi trường để tạo ra một bean MockMvc. Đây là một cách để bạn "giả lập" việc gửi các HTTP requests đến các endpoint trong ứng dụng của bạn mà không cần thực sự khởi động ứng dụng. 
-  MockMvc cho phép bạn thực hiện kiểm tra về việc xử lý `HTTP requests`, kiểm tra các response, và kiểm tra các giá trị được trả về từ controller mà không cần tạo ra một máy chủ thực sự.

```java
@SpringBootTest
@AutoConfigureMockMvc
public class MyControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testGetEndpoint() throws Exception {
        mockMvc.perform(get("/api/some-endpoint"))
               .andExpect(status().isOk())
               .andExpect(content().string("Expected response content"));
    }
}
```

