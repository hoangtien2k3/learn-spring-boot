package com.hoangtien2k3.springbootcrudrestapivalidation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

// Create JPA Entity and Implementing Validations on the Bean - Employee.java
@Entity // đánh dấu một thực thể
@Table(name = "employees") // table mysql
public class Employee {
    private long id;
    @NotNull // đánh dấu giá trị không được nulll
    @Size(min = 2, message = "First Name should hava at least 2 characters") // kích thước ít nhất là 2 ký tự, nếu không mé ra message
    private String firstName;
    @NotNull
    @Size(min = 2, message = "Last Name should have at least 2 characters")
    private String lastName;
    @Email  // kiểm tra email có đúng định dạng không
    @NotBlank // kiểm tra email có khoảng trống không
    private String emailId;
    @NotNull
    @Size(min = 2, message = "Passport should have at least 2 characters")
    private String passportNumber;

    public Employee() {
    }

    public Employee(long id, String firstName, String lastName, String emailId, String passportNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.passportNumber = passportNumber;
    }

    @Id // Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Id tự động sinh
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false) // trường first_name và không thể null
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email_address", nullable = false)
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Column(name = "passport_number", nullable = false)
    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
