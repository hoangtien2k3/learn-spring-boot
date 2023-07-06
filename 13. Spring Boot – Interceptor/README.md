
## [13. Spring Boot – Interceptor]()

Trong Spring Boot, Interceptor là một cơ chế cho phép bạn can thiệp vào quá trình xử lý yêu cầu trước và sau khi nó được xử lý bởi các phương thức xử lý (handler methods). Interceptor cho phép bạn thực hiện các logic chung hoặc kiểm tra trước và sau khi xử lý yêu cầu, chẳng hạn như kiểm tra quyền truy cập, ghi log, xử lý ngoại lệ, gắn thêm dữ liệu vào yêu cầu hoặc phản hồi, v.v.

Một Interceptor được triển khai bằng cách sử dụng interface HandlerInterceptor và triển khai các phương thức trong đó. Có ba phương thức chính bạn có thể triển khai:

[preHandle()](): Phương thức này được gọi trước khi quá trình xử lý yêu cầu bắt đầu. Nó trả về giá trị boolean để chỉ định xem xử lý yêu cầu có tiếp tục hay không. Nếu trả về true, quá trình xử lý tiếp tục, ngược lại, quá trình xử lý kết thúc và phản hồi được trả về cho người dùng.

[postHandle()](): Phương thức này được gọi sau khi quá trình xử lý yêu cầu, nhưng trước khi phản hồi được trả về cho người dùng. Bạn có thể sử dụng phương thức này để thay đổi hoặc bổ sung dữ liệu trong mô hình và lưu trữ nó cho việc sử dụng bởi view.

[afterCompletion()](): Phương thức này được gọi sau khi phản hồi đã được trả về cho người dùng. Nó được sử dụng để thực hiện các tác vụ sau khi yêu cầu đã hoàn thành, chẳng hạn như giải phóng tài nguyên, ghi log cuối cùng, v.v.

```java

@Component
public class ProductServiceInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
    }
}
```

```java

@Component
public class ProductServiceInterceptorAppConfig extends WebMvcConfigurerAdapter {
    @Autowired
    ProductServiceInterceptor productServiceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(productServiceInterceptor);
    }
}
```






















