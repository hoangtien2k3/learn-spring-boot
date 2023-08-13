package com.hoangtien2k3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hoangtien2k3.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}