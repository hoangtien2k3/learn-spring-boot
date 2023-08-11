
## Spring Boot Project Architecture

### Three Tier (Three Layer) Architecture
- Spring Boot tuân theo kiến ​​trúc phân lớp, trong đó mỗi lớp giao tiếp với lớp ngay bên dưới hoặc bên trên (cấu trúc phân cấp) nó:

![image](https://github.com/hoangtien2k3qx1/learn-spring-boot/assets/122768076/6819019c-5bd6-443f-83db-79a5b8e75ad7)


- `Presentation layer`: Đây là giao diện người dùng của ứng dụng trình bày các tính năng và dữ liệu của ứng dụng cho người dùng.
- `Business logic (or Application) layer`: Lớp này chứa logic nghiệp vụ điều khiển các chức năng cốt lõi của ứng dụng. Như đưa ra quyết định, tính toán, đánh giá và xử lý dữ liệu truyền giữa hai lớp còn lại.
- `Data access layer (or Data) layer`: Lớp này chịu trách nhiệm tương tác với cơ sở dữ liệu để lưu và truy xuất dữ liệu ứng dụng.


## Spring Boot Flow Architecture
![image](https://github.com/hoangtien2k3qx1/learn-spring-boot/assets/122768076/012fd4c7-477a-4414-89f2-220efb863bb9)

1. Bộ điều khiển Spring MVC nhận yêu cầu HTTP từ máy khách (trình duyệt).
2. Bộ điều khiển Spring MVC xử lý yêu cầu và gửi yêu cầu đó đến lớp dịch vụ.
3. Lớp dịch vụ chịu trách nhiệm giữ logic nghiệp vụ của ứng dụng.
4. Tầng lưu trữ chịu trách nhiệm tương tác với cơ sở dữ liệu để lưu và truy xuất dữ liệu ứng dụng.
5. Chế độ xem trả về bộ điều khiển Spring MVC (JSP hoặc Thymeleaf) để hiển thị trên trình duyệt.
