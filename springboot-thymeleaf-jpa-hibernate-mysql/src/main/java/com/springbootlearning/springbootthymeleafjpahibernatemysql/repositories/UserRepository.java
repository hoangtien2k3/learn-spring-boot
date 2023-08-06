package com.springbootlearning.springbootthymeleafjpahibernatemysql.repositories;

import com.springbootlearning.springbootthymeleafjpahibernatemysql.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
