package Demowebservice.accountservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity     //chỉ ra đây là 1 entity(thực thể)
@Table(name = "account")  // tạo table trong database
@Data   // lomm bock
public class Acount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    private String password;

    @Column(name = "username", unique = true)
    private String username;

    @ElementCollection
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "account_id"))
    @Column(name = "role")
    private Set<String> roles;
}
