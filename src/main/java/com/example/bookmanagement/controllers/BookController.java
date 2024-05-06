package com.example.bookmanagement.controllers;

import com.example.bookmanagement.entities.Book;
import com.example.bookmanagement.services.BookService;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller("/books")
public class BookController {

    private final BookService bookService;

    @Inject
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Get("/")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @Get("/{id}")
    public Book getBookById(Long id) {
        return bookService.getBookById(id);
    }

    @Post("/")
    public Book createBook(@Body Book book) {
        return bookService.createBook(book);
    }

    @Put("/{id}")
    public Book updateBook(Long id, @Body Book book) {
        return bookService.updateBook(id, book);
    }

    @Delete("/{id}")
    public void deleteBook(Long id) {
        bookService.deleteBook(id);
    }
}
