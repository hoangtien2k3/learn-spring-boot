package com.springbootlearning.springbootrestfulwebservices.repository;

import com.springbootlearning.springbootrestfulwebservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
