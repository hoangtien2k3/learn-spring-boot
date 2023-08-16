package com.hoangtien2k3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hoangtien2k3.repository.UserRepository;
import com.hoangtien2k3.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<User> findByUsernameOrEmail(String username, String email);
    boolean existByUsername(String username);
}
