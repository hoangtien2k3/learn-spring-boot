
## IoC Container

- `IoC Container` trong Spring chính là lõi của Spring Framework.
- `IoC Container` sẽ tạo ra các đối tượng, nối chúng lại với nhau, cấu hình chúng, và quản lý vòng đời của chúng từ khi tạo ra đến khi bị hủy.
- `IoC Container` sử dụng DI (Dependency Injection) để quản lý các thành phần tạo nên một ứng dụng.
- Những đối tượng này được gọi là `Spring Bean`.
- `IoC Container` được cung cấp thông tin từ các tập tin XML.


### Có 2 loại IoC Container
1. [BeanFactory]()
2. [ApplicationContext]()


## BeanFactory
- Đây là container đơn giản nhất cung cấp hỗ trợ cơ bản cho DI và được xác định bởi giao diện org.springframework.beans.factory.BeanFactory.
- BeanFactory và các giao diện có liên quan, như `BeanFactoryAware`, `InitializingBean`, `DisposableBean` vẫn còn tồn tại trong Spring vì mục đích tích hợp các framework bên thứ ba với Spring.


```kotlin
Resource resource = new ClassPathResource("applicationContext.xml");
BeanFactory factory = new XmlBeanFactory(resource);
```


## ApplicationContext
- ClassPathXmlApplicationContext là lớp thực hiện của giao diện ApplicationContext. 
- Chúng ta cần phải tạo ra thể hiện của lớp ClassPathXmlApplicationContext để sử dụng ApplicationContext như dưới đây

```java
ApplicationContext context =   
    new ClassPathXmlApplicationContext("applicationContext.xml");
```

Constructor của lớp ClassPathXmlApplicationContext nhận tham số truyền vào là một chuỗi, vì vậy chúng ta truyền tên của tập tin xml để tạo ra thể hiện của ApplicationContext.



