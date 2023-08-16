
## Spring Boot DTO Example - Entity To DTO Conversion

=> tại sao cần dùng mô hình thực thể DTO
- `Tách Biệt Dữ Liệu Nội Bộ và Dữ Liệu Giao Tiếp`: DTO giúp bạn tách biệt cấu trúc dữ liệu nội bộ của ứng dụng với dữ liệu mà bạn gửi tới hoặc nhận từ khách hàng. Điều này giữ cho dữ liệu nội bộ an toàn và ẩn các chi tiết không cần thiết khỏi khách hàng.

- `Kiểm Soát Dữ Liệu Gửi Đi`: Sử dụng DTO cho phép bạn kiểm soát chính xác dữ liệu nào sẽ được gửi tới khách hàng. Bạn có thể loại bỏ hoặc ẩn các trường dữ liệu không cần thiết hoặc nhạy cảm mà bạn không muốn khách hàng thấy.

- `Quản Lý Phiên Bản và Tiến Hóa`: Trong quá trình phát triển, dữ liệu bạn gửi và nhận có thể thay đổi. Sử dụng DTO giúp bạn quản lý tiến hóa dữ liệu mà không cần thay đổi trực tiếp API mà khách hàng sử dụng, do đó giảm thiểu tác động lên khách hàng của bạn.

- `Ánh Xạ và Chuyển Đổi`: Trong một số trường hợp, dữ liệu nội bộ và dữ liệu giao tiếp có thể có cấu trúc khác nhau. DTO cho phép bạn thực hiện ánh xạ và chuyển đổi dễ dàng giữa các cấu trúc này.

- `Tối Ưu Kích Thước Dữ Liệu`: Đôi khi, dữ liệu nội bộ có thể lớn hơn so với dữ liệu mà bạn muốn gửi tới khách hàng. Sử dụng DTO cho phép bạn tạo ra dữ liệu tối ưu hơn cho giao tiếp API.

![image](https://github.com/hoangtien2k3qx1/hoangtien2k3qx1/assets/122768076/3a42d839-6203-45f9-8df4-35956adf629f)