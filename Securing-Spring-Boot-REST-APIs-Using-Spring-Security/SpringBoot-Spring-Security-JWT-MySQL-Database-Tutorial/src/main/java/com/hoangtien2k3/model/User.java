package com.hoangtien2k3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;


    // FetchType.EAGER: dữ liệu của mối quan hệ sẽ được tải ngay lập tức cùng với entity chính
    // CascadeType.ALL tất cả các hoạt động CRUD (Create, Read, Update, Delete) trên entity chính
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",                                                            // Tên của bảng trung gian
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),           // Khóa ngoại đến Student
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")     // Khóa ngoại đến Course
    )
    private Set<Role> roles; // khai báo mối quan hệ Has-a
}
