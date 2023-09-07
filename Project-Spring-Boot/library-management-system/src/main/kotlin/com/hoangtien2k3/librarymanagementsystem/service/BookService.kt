package com.hoangtien2k3.librarymanagementsystem.service

import com.hoangtien2k3.librarymanagementsystem.entity.Book
import com.hoangtien2k3.librarymanagementsystem.repository.BookRepository
import com.hoangtien2k3.librarymanagementsystem.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookService {

    @Autowired
    private lateinit var bookRepository: BookRepository

    @Autowired
    private lateinit var userRepository: UserRepository

    fun findAll(): List<Book> {
        return bookRepository.findAll()
    }

    fun findById(id: Long): Book? {
        return bookRepository.findById(id).orElse(null)
    }

    fun save(book: Book): Book {
        return bookRepository.save(book)
    }

    fun deleteById(id: Long) {
        bookRepository.deleteById(id)
    }

    fun borrowBook(bookId: Long, userId: Long): Book? {
        val book = findById(bookId)
        val user = userRepository.findById(userId).orElse(null)

        if (book != null && book.borrowed == false && user != null) {
            book.borrowedBy = user
            book.borrowed = true
            return save(book)
        }
        // Handle errors (e.g., book not found, book already borrowed, user not found)
        return null
    }

    fun returnBook(bookId: Long): Book? {
        val book = findById(bookId)
        if (book != null && book.borrowed == true) {
            book.borrowedBy = null
            book.borrowed = false
            return save(book)
        }
        // Handle errors (e.g., book not found, book not borrowed)
        return null
    }
}
