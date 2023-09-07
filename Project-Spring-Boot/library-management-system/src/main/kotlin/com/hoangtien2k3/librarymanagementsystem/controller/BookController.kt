package com.hoangtien2k3.librarymanagementsystem.controller

import com.hoangtien2k3.librarymanagementsystem.entity.Book
import com.hoangtien2k3.librarymanagementsystem.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/books")
class BookController {

    @Autowired
    private lateinit var bookService: BookService

    @GetMapping
    fun getAllBooks(): List<Book> {
        return bookService.findAll()
    }

    @GetMapping("/{id}")
    fun getBook(@PathVariable id: Long): Book? {
        return bookService.findById(id)
    }

    @PostMapping
    fun addBook(@RequestBody book: Book): Book {
        return bookService.save(book)
    }

    @PutMapping("/{id}")
    fun updateBook(@PathVariable id: Long, @RequestBody book: Book): Book {
        // Additional logic to ensure you're updating the correct book
        return bookService.save(book)
    }

    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable id: Long) {
        bookService.deleteById(id)
    }

    // ... other endpoints ...
    @PostMapping("/{bookId}/borrow/{userId}")
    fun borrowBook(@PathVariable bookId: Long, @PathVariable userId: Long): ResponseEntity<Book> {
        val borrowedBook = bookService.borrowBook(bookId, userId)
        return if (borrowedBook != null) {
            ResponseEntity.ok(borrowedBook)
        } else {
            ResponseEntity.badRequest().build() // or a more descriptive error response
        }
    }

    @PostMapping("/{bookId}/return")
    fun returnBook(@PathVariable bookId: Long): ResponseEntity<Book> {
        val returnedBook = bookService.returnBook(bookId)
        return if (returnedBook != null) {
            ResponseEntity.ok(returnedBook)
        } else {
            ResponseEntity.badRequest().build() // or a more descriptive error response
        }
    }
}