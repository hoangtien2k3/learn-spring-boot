## Xử lý Exception Handling trong Java - Spring Booot:

Trong ứng dụng Spring Boot, bạn có thể xử lý các exception bằng cách sử dụng các annotation như `@ControllerAdvice` và `@ExceptionHandler`.

1. Tạo một class `ExceptionHandler` và đánh dấu nó bằng annotation `@ControllerAdvice` để định nghĩa một global exception handler cho ứng dụng.
```java
@ControllerAdvice
public class ExceptionHandler {
}
```

2. Để xử lý một loại exception cụ thể, tạo một method trong class `ExceptionHandler` và đánh dấu nó bằng annotation `@ExceptionHandler` và chỉ định loại exception mà method đó sẽ xử lý.
```java
@ControllerAdvice
public class ExceptionHandler {

  @ExceptionHandler(YourException.class)
  public ResponseEntity<String> handleYourException(YourException ex) {
    // Xử lý và trả về một ResponseEntity, ví dụ:
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
  }
}
```

3. Bên trong method xử lý exception, bạn có thể xử lý exception bằng các cách tùy ý, ví dụ như gửi một thông báo lỗi đến Client hoặc log exception.

Trong ví dụ trên, chúng ta trả về một `ResponseEntity` với mã HTTP status là `500` và body là thông báo lỗi "Internal server error".
```java
@ControllerAdvice
public class ExceptionHandler {

  @ExceptionHandler
  public ResponseEntity<String> handleGlobalException(Exception ex) {
    // Xử lý và trả về một ResponseEntity
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
  }
}
```



