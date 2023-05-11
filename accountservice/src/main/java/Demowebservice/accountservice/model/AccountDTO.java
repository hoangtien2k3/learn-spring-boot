package Demowebservice.accountservice.model;

import lombok.Data;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import java.util.Set;

@Data // dung lombok
public class AccountDTO {
    private Long id;
    private String name;
    private String password;
    private String username;
    private Set<String> roles;
}
