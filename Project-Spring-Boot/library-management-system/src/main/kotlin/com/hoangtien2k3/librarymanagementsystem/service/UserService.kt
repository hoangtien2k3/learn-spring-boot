package com.hoangtien2k3.librarymanagementsystem.service

import com.hoangtien2k3.librarymanagementsystem.entity.User
import com.hoangtien2k3.librarymanagementsystem.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    fun findAll(): List<User> {
        return userRepository.findAll()
    }

    fun save(user: User): User {
        return userRepository.save(user)
    }
}