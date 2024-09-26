package com.crisilto.crud.services;

import com.crisilto.crud.model.Book;
import com.crisilto.crud.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repository;
    public BookService(BookRepository repository) {
        this.repository = repository;
    }
    public List<Book> getAllBooks() {
        return repository.getAllBooks();
    }

    public long createBook(Book newBook) {
        return repository.createBook(newBook);
    }

    public Book getBookById(long id) {
        return repository.getBookById(id);
    }

    public Book updateBook(long id, Book updatedBook) {
        return repository.updateBook(id, updatedBook);
    }
}
