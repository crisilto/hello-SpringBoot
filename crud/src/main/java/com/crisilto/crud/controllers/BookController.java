package com.crisilto.crud.controllers;

import com.crisilto.crud.model.Book;
import com.crisilto.crud.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/books")
    public long createBook(@RequestBody Book newBook) {
        return bookService.createBook(newBook);
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable long id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable long id, @RequestBody Book updatedBook) {
        return bookService.updateBook(id, updatedBook);
    }
}
