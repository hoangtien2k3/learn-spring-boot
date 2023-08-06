package com.learnspringboot.springbootjparestapi.repository;

import com.learnspringboot.springbootjparestapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}