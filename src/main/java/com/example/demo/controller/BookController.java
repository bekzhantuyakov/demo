package com.example.demo.controller;

import com.example.demo.dto.BookDto;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public BookDto createNewBook(@RequestBody BookDto dto) {
        return bookService.createNewBook(dto);
    }

    @PutMapping
    public BookDto updateExistingBook(@RequestBody BookDto dto) {
        return bookService.updateBookById(dto);
    }

    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable Integer id) {
        bookService.deleteBookById(id);
        return "Success delete";
    }
}
