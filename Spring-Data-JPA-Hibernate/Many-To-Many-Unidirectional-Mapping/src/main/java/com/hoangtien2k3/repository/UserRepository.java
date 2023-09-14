package com.hoangtien2k3.repository;


import com.hoangtien2k3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}