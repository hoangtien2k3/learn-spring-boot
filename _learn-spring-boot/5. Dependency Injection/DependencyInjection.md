
# Dependency injection (DI) và Dependency inversion

- `Dependency inversion` là nguyên tắc quan trọng trong việc thiết kế và xây dựng các hệ thống phần mềm. Nguyên tắc này chỉ ra rằng các module phụ thuộc vào các abstraction, chứ không phải các module cụ thể. Điều này giúp giảm sự phụ thuộc cứng giữa các module và làm cho code dễ dàng mở rộng và tạo unit test.
- `Dependency injection` là một phương pháp cụ thể để triển khai nguyên tắc Dependency inversion. Dependency injection là việc cung cấp các dependency (phụ thuộc) cho một object từ bên ngoài thay vì yêu cầu object tạo ra chúng một cách tự động. Dependency injection có thể được thực hiện thông qua các hình thức như constructor injection, setter injection hoặc interface injection.

=> Nói tóm lại, dependency inversion và dependency injection có mối liên hệ chặt chẽ với nhau. Dependency inversion là một nguyên tắc thiết kế, trong khi dependency injection là một phương pháp triển khai nguyên tắc đó.


## 1. Dependency inversion principle

```java
class ChinaEngine {
    ...
}

class Car {
    private ChinaEngine engine;
    public Car() {
        // Khi tạo Car thì nhớ gắn engine vào :D
        engine = new ChinaEngine();
    }
}
```

DI principle có hai ý chính:

- Các module cấp cao không nên phụ thuộc (trực tiếp) vào module cấp thấp. Cả hai nên phụ thuộc vào abstraction (của OOP).
- Abstraction không nên phụ thuộc vào chi tiết, mà ngược lại.


### 2.2. Ý thứ nhất của DI principle
Để đúng với DI principle, chúng ta sửa lại như sau. Bằng cách cho cả hai module cùng phụ thuộc vào abstraction (trong OOP thường là interface).

```java
// Interface đại diện cho mọi loại động cơ
interface Engine {
    ...
}

// ChinaEngine là một loại Engine
class ChinaEngine implements Engine {
    ...
}

// Trong Car thì chỉ dùng Engine (chung chung), không có cụ thể loại nào
// Loại engine cụ thể sẽ được inject vào lúc tạo (không phải gán cứng trong code)
// Do đó có thể tạo Car với các loại Engine khác nhau
class Car {
    // Loại engine nào đó, lợi dụng tính đa hình OOP
    private Engine engine;
    
    // Khi tạo Car thì tạo Engine object trước, rồi inject vào constructor này
    public Car(Engine engine) {
        this.engine = engine;
    }
}
```











