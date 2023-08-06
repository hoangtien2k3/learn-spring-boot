package com.springbootlearning.springbootmysqljpahibernaterestfullcrudapi.repository;

import com.springbootlearning.springbootmysqljpahibernaterestfullcrudapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}