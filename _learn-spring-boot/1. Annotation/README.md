
## Spring Boot Annotations 

#### Core Spring Framework Annotations

[@Required](): nó được áp dụng cho phương thức setter method. Nó chỉ ra rằng Bean được chú thích phải điền vào thời điểm cấu hình, nếu không thì nó sẽ ném ra ngoại lên 'BeanInitilizationException'

[@Autowired](): nó được sử dụng để tiêm(inject) đối tượng vào các phương thức 'setter', 'instance variable' và 'constructor'. @Autowired, bộ chứa lò xo sẽ tự động kết nối bean bằng cách khớp loại dữ liệu.

[@Configuration](): Nó là một chú thích cấp bậc.Lớp được chú thích '@Configuration' sử dụng làm nguồn định nghĩa 'Bean'

[@ComponentScan](): là annotation khai báo ở cấp độ class, giống như cái tên của nó, annotation @ComponentScan dùng để scan toàn bộ bean trong ứng dụng, mặc định nó sẽ scan tất cả bean trong package ở vị trí đặt class chưa hàm main, ngoài ra chúng ta cũng có thể tùy chỉnh package cần scan. thường thì annotation @ComponentScan sẽ đi chung vớ @ComponentScan.

Các param trong `@ComponentScan`:
- `basePackages`: dùng để chỉ ra những package cần scan, bạn có thể truyền vào một hoặc nhiều package name
- `basePackageClasses`: chỉ ra những class cần scan
- `excludeFilters`: dùng để filter loại trừ những bean or package không cần scan
- `includeFilters`: Dùng dể filter những bean or package cần scan.
- `lazyInit`: dùng để lazy load bean, default = false
- `resourcePattern`: chỉ ra các pattern file để Spring có thể scan, default pattern "**/*.class"

[@Bean](): nó là một annotation cho method. Nó là sự thay thể của thẻ XML <bean>. Nó cho biết method tạo ra một bean được Spring Container quản lý.

## Các mẫu Spring Boot Annotations:

[@Component]() :  là một annotation của class. Nó dùng để đánh dấu class Java là một bean. Một class Java được đánh dấu @Component được tìm thấy trong classpath. Spring Framework chọn nó và cấu hình trong ngữ cảnh ứng dụng như một Spring Bean.

[@Controller](): là một annotation ở class. Là một chuyên môn hóa của @Component. Nó đánh dấu class là một class để xử lý request web. Nó thường được sử dụng để phục vụ các request từ UI. Mặc định thì nó trả về một chuỗi cho biết route nào cần redirect. Nó chủ yếu được sử dụng với annotation @RequestMapping.

[@Service]() : nố thường được sử dụng ở class. Nó cho biết Spring biết rằng class này chứa business login.

[@Repository](): nó thường được dụng ở class. Repository là một DAOs (Data Access Object) cái mà sẽ truy cập trực tiếp vào database. Repository thực hiện tất cả các hoạt động liên quan đến database.


## Spring Boot Annotations:

[@EnableAutoConfiguration]() : Nó tự động cấu hình bean có trong classpath và cấu hình nó để chạy các phương thức. Việc sử dụng chú thích này bị giảm trong bản phát hành Spring Boot 1.2.0 vì các nhà phát triển đã cung cấp một giải pháp thay thế cho chú thích, tức là `@SpringBootApplication.`

[@SpringBootApplication]() : Nó là sự kết hợp của 3 chú thích: `@EnableAutoConfiguration`, `@ComponentScan`, `@Configuration.`


## Spring MVC and REST Annotations:

[@RequestMapping]() :  nó được sử dụng để map các request. Nó có nhiều phần tử tùy chọn như `consumes`, `header`, `method`, `name`, `params`, `path`, `produces`, và `value`. Chúng tôi sử dụng nó với lớp cũng như phương thức

[@GetMapping]() : nó map HTTP GET request trên method cụ thể. Nó dùng để tạo một điểm cuối trong web service, và nó được sử dụng thay cho `@RequestMapping(method = RequestMethod.GET)`.

[@PostMapping](): sử dụng khi gửi data tới server để tạo ra tài nguyên mới. Thay cho `@RequestMapping(method = RequestMethod.POST)`.

[@PutMapping](): sử dụng để thay đổi thông tin của một tài nguyên đã tồn tại trong hệ thống bằng cách sử dụng nội dung trong body của request. Nó được sử dụng thay vì sử dụng: `@RequestMapping (method = RequestMethod.PUT)`.

[@DeleteMapping](): sử dụng để xóa một resource chỉ định. Nó được sử dụng thay vì sử dụng: @RequestMapping (method = RequestMethod.DELETE).


## TỔNG HỢP TÀI LIỆU LẬP TRÌNH

[@PatchMapping](): Sử dụng để áp dụng sửa đổi 1 phần cho resource. Nó được sử dụng thay vì sử dụng: `@RequestMapping (method = RequestMethod.PATCH)`

[@RequestBody](): Nó được sử dụng để liên kết yêu cầu HTTP với một đối tượng trong một tham số phương thức. Bên trong nó sử dụng `HTTP MessageConverters` để chuyển đổi phần thân của yêu cầu. Khi chúng tôi chú thích một tham số phương thức với `@RequestBody`, Spring sẽ liên kết phần body yêu cầu HTTP đến với tham số đó.

[@RequestHeader](): Nó được sử dụng để lấy thông tin chi tiết về tiêu đề yêu cầu HTTP. Chúng tôi sử dụng chú thích này như một tham số phương thức. Các phần tử tùy chọn của chú thích là `name`, `required`, `value`, `defaultValue`. Đối với mỗi chi tiết trong tiêu đề, chúng ta nên chỉ định các chú thích riêng biệt. Chúng ta có thể sử dụng nó nhiều lần trong một phương pháp.

[@RestController]():  là một composed annotation được kết từ annotation @Controller và @ResponseBody, khi đặt một annotation @RestController trên một class controller thì mọi method controller trong class đó sẽ được thừa hưởng annotation `@ResponseBody` và response data trong controller này sẽ được trả về dưới dạng `message`.


[@ControllerAdvice](): được sử dụng trong ứng dụng Spring Boot khi bạn có các controller truyền thống sử dụng @Controller để xử lý các yêu cầu HTTP. Annotation này cho phép bạn xử lý các exception toàn cục (global exception handling) chung cho toàn bộ các controller trong ứng dụng. Khi sử dụng `@ControllerAdvice`, bạn cần kết hợp với các phương thức được đánh dấu bằng `@ExceptionHandler` để xác định xử lý cho từng loại exception cụ thể.


[@RestControllerAdvice](): cũng được sử dụng để xử lý các exception, nhưng chủ yếu dành cho các ứng dụng RESTful API. Annotation này kết hợp giữa `@ControllerAdvice` và `@ResponseBody`, cho phép trả về các thông báo lỗi dưới dạng các đối tượng JSON. Khi sử dụng @RestControllerAdvice, bạn không cần kết hợp với @ExceptionHandler, mà bạn có thể đánh dấu các phương thức xử lý exception trực tiếp với @ExceptionHandler.


[@ExceptionHandler](): là một trong những annotation quan trọng trong Spring Boot, được sử dụng để xử lý các exception (ngoại lệ) xảy ra trong controller của ứng dụng. @ExceptionHandler cho phép bạn đánh dấu một phương thức trong controller để xử lý exception đó và trả về một thông báo lỗi phù hợp cho client.


[@EntityListeners(AuditingEntityListener.class)](): thường được sử dụng để kích hoạt tính năng Auditing (theo dõi) trong Spring Boot, cho phép tự động ghi thông tin thời gian (thời gian tạo và thời gian cập nhật) và người dùng (người tạo và người cập nhật) vào các bản ghi trong cơ sở dữ liệu.


[@NoArgsConstructor và @AllArgsConstructor]() : là một số trong số những annotation mạnh mẽ của Lombok, được sử dụng để tự động tạo các constructor trong các lớp Java `Lombok`.









