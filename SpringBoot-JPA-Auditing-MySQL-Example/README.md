
## Table of Contents
- What we’ll build
- Tools and Technologies Used
- Creating and Importing a Project
- Packaging Structure
- The pom.xml File
- Configuring MySQL Database 
- Create Generic Auditable Class with Spring Data Annotations @CreatedBy, @CreatedDate, @LastModifiedBy, and @LastModifiedDate 
- Create a JPA Entity which extends Auditable Class - User.java 
- Auditing Author Using AuditorAware and Spring Security
- Enable JPA Auditing by Using @EnableJpaAuditing
- Create Spring Data JPA Repository - UserRepository.java
- Creating UserController(Contains REST APIs)
- Running the Application
- Source code on GitHub

## 1. What we’ll build
- We are building a simple Spring boot CRUD Rest APIs to demonstrate the usage of Spring Data JPA auditing with MySQL as a database.

## 2. Tools and Technologies Used
- Spring Boot - 3
- JDK - 17 or later
- Spring Framework - 6+
- Maven - 3.2+
- IDE - Eclipse or Spring Tool Suite (STS)
- MYSQL


## Data JPA Auditing trong SpringBoot

- Data JPA Auditing là một tính năng trong Spring Data JPA giúp tự động theo dõi và ghi nhận thông tin về ngày tạo và ngày cập nhật của các đối tượng trong cơ sở dữ liệu. 
- Tính năng này giúp bạn quản lý thông tin thay đổi của các bản ghi mà không cần phải thực hiện thủ công.


## [Kích hoạt Auditing](): Trước hết, bạn cần kích hoạt tính năng Auditing trong ứng dụng Spring bằng cách sử dụng annotation @EnableJpaAuditing trên một cấu hình hoặc cấu hình chính của ứng dụng.
```java
@SpringBootApplication
@EnableJpaAuditing // đánh dấu sử dụng anotation `@EnableJpaAuditing` 
public class YourApplication {
    public static void main(String[] args) {
        SpringApplication.run(YourApplication.class, args);
    }
}
```

## [Tạo các trường ngày tạo và ngày cập nhật trong các đối tượng của bạn]():
```java
@Entity
@EntityListeners(AuditingEntityListener.class)
public class YourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other fields

    @CreatedDate // ngày tạo
    private LocalDateTime createdAt;

    @LastModifiedDate // ngày cập nhật gần nhất
    private LocalDateTime updatedAt;

    // Getters and setters
}
```

