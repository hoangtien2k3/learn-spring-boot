package com.hoangtien2k3.librarymanagementsystem.controller

import com.hoangtien2k3.librarymanagementsystem.entity.User
import com.hoangtien2k3.librarymanagementsystem.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController {
    @Autowired
    lateinit var userService: UserService

    @GetMapping
    fun getAllUsers(): List<User> {
        return userService.findAll()
    }

    @PostMapping
    fun addUser(@RequestBody user: User): User {
        return userService.save(user)
    }

}