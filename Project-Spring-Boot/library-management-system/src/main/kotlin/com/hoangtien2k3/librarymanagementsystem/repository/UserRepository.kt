package com.hoangtien2k3.librarymanagementsystem.repository

import com.hoangtien2k3.librarymanagementsystem.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>{
}