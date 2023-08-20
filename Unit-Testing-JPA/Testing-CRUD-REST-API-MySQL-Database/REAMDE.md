
## Unit Testing in Spring Boot Java


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


