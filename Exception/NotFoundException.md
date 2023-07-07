
## [Not Found Exception in Java]()

### @ControllerAdvice và @ExceptionHandler trong Spring Framework để xử lý ngoại lệ (exception) trong quá trình xử lý các yêu cầu HTTP.
- @ControllerAdvice là một annotation được sử dụng để chỉ định rằng một class được đánh dấu bởi nó sẽ chứa các phương thức xử lý ngoại lệ chung cho tất cả các controller trong ứng dụng.
- @ExceptionHandler là một annotation được sử dụng để đánh dấu một phương thức trong ControllerAdvice class để xử lý một loại ngoại lệ cụ thể.

Example:

=> Lớp `CloudVendorExceptionHandler`
```java
@ControllerAdvice
public class CloudVendorExceptionHandler {
    @ExceptionHandler(value = {CloudVendorNotFoundException.class})
    public ResponseEntity<Object> handlerCloudVendorNotFoundException
            (CloudVendorNotFoundException cloudVendorNotFoundException)
    {
        CloudVendorException cloudVendorException = new CloudVendorException(
                cloudVendorNotFoundException.getMessage(),
                cloudVendorNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(cloudVendorException, HttpStatus.NOT_FOUND);
    }
}
```

=> Lớp `CloudVendorException`
```java
public class CloudVendorException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

    public CloudVendorException(String message, Throwable throwable, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
```

=> Lớp `CloudVendorNotFoundException`
```java
public class CloudVendorNotFoundException extends RuntimeException {
    public CloudVendorNotFoundException(String message) {
        super(message);
    }

    public CloudVendorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

