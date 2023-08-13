package com.hoangtien2k3.springboot.repository;

import com.hoangtien2k3.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
