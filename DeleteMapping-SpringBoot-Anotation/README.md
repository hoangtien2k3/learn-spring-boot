
## [@DeleteMapping Annotation Overview]()

- `@DeleteMapping` viết tắt của @RequestMapping(method = RequestMethod.DELETE)

Chú thích @DeleteMapping có các phần tử tùy chọn sau

1. `consumes`: Được sử dụng để chỉ định các định dạng phương thức này có thể xử lý. Nếu yêu cầu DELETE có định dạng không nằm trong danh sách được chỉ định ở consumes, thì phương thức sẽ không được gọi.
2. `headers`: Cho phép bạn chỉ định các header của yêu cầu HTTP mà phải tồn tại để phương thức DELETE được gọi.
3. `name`: Được sử dụng để đặt tên cho phương thức, điều này có thể hữu ích trong việc tạo các bản đồ ánh xạ URL tùy chỉnh.
4. `path`: Chỉ định một đường dẫn URI mà phải khớp với yêu cầu DELETE để phương thức xử lý.
5. `produces`: Được sử dụng để chỉ định các định dạng phản hồi mà phương thức này có thể tạo ra. Nếu yêu cầu DELETE không thể chấp nhận một định dạng nằm trong danh sách produces, thì phương thức sẽ không được gọi.
6. `value`: Định nghĩa một hoặc nhiều đường dẫn URI mà phương thức này sẽ xử lý.

Example:
```java
@RestController
@RequestMapping("/api/users")
public class UserController {

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        // Xử lý logic để xóa người dùng với id cụ thể
        // Trả về phản hồi thành công hoặc thất bại
    }
}
```
