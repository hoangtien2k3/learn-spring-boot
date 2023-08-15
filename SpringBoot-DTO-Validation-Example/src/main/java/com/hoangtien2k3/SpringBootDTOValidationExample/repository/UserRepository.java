package com.hoangtien2k3.SpringBootDTOValidationExample.repository;

import com.hoangtien2k3.SpringBootDTOValidationExample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

}