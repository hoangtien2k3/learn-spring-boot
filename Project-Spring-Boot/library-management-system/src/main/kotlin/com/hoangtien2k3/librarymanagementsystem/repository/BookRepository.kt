package com.hoangtien2k3.librarymanagementsystem.repository

import com.hoangtien2k3.librarymanagementsystem.entity.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long>{
}