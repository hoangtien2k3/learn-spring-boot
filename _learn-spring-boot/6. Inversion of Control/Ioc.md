
# Inversion of Control (IoC)

Tuy nhiên, nếu chương trình có nhiều module, nhiều object thì sẽ gặp tình trạng như:

- Gắn thiếu module vào module khác
- Phải quan tâm tới thứ tự khởi tạo module (tạo module nào trước)
- Phụ thuộc vòng (A phụ thuộc B, và B cũng phụ thuộc A, suy ra không biết tạo A hay B trước)

=> `IoC` nhằm mục đích đơn giản hóa quá trình tạo đối tượng và liên kết giữa chúng, bằng cách tuân theo nguyên tắc: `Không tạo đối tượng`, chỉ mô tả cách chúng sẽ được tạo ra.


Lưu điểm:
- nhờ có IoC chúng ta không cần tự mình tạo các module bằng new như trước nữa.
```java
Engine goodEngine = new VNEngine();
Car myCar = new Car(goodEngine);
```

- IoC framework sẽ dựa vào đó để tạo module đúng theo yêu cầu.
```java
@Component
class VNEngine implements Engine {
    ...
}

@Component
class Car {
    // Tìm object tương ứng với Engine và chèn (inject) vào đây
    @Autowired
    private Engine engine;
}
```

## 2.2. Các loại injection

Có 2 loại chính:

- Constructor-based injection: Dùng inject các module bắt buộc. Các module được inject nằm trong constructor, và được gán lần lượt vào các field.
- Setter-based injection: Dùng inject các module tùy chọn. Mỗi module sẽ được inject thông qua setter, nằm ở tham số và cũng gán cho field nào đó.

```java
@Component
class Car {
    // Bắt buộc, vì xe thì phải có động cơ
    private Engine engine;

    // Tùy chọn, vì xe có thể không có người chủ
    private Human owner;

    // Do engine bắt buộc, nên dùng constructor based injection
    // Constructor based có thể inject nhiều dependency cùng lúc
    public Car(Engine engine) {
        this.engine = engine;
    }

    // Do owner là tùy chọn, nên dùng setter based injection
    // Setter based chỉ inject một dependency mỗi setter
    public void setOwner(Human owner) {
        this.owner = owner;
    }
}
```

## 3. Áp dụng vào Spring Boot

nhiệm vụ tạo và quản lý các module
- IoC container của Spring gọi là `Application context`
- Các module chứa trong IoC container được Spring gọi là các `Bean`











