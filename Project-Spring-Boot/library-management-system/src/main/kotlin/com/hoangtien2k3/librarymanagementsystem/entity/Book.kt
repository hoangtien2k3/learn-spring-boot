package com.hoangtien2k3.librarymanagementsystem.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class Book(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var title: String? = null,
        var author: String? = null,
        var borrowed: Boolean? = null,
        @ManyToOne
        @JoinColumn(name = "user_id")
        var borrowedBy: User? = null
)