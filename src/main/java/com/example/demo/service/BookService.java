package com.example.demo.service;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookDto> getAllBooks(){
        List<Book>books = bookRepository.findAll();

        List<BookDto> result = new ArrayList<>();
        for (int i =0;i<books.size();i++){
            result.add(new BookDto(books.get(i)));
        }
        return result;
    }
    public BookDto getBookById(int bookId){
        Optional<Book> book = bookRepository.findById(bookId);
        if(book.isPresent()){
            return new BookDto(book.get());
        }else{
            return null;
        }

    }

    public BookDto createNewBook(BookDto bookDto) {
          Book newBook = new Book(bookDto);
          Book savedNewBook = bookRepository.save(newBook);
          return new BookDto(savedNewBook);
    }

    public BookDto updateBookById(BookDto bookDto) {
        Optional<Book> book = bookRepository.findById(bookDto.getId());
        if(book.isPresent()){
            Book bookToSave = book.get();
            bookToSave.setName(bookDto.getName());
            Book savedNewBook = bookRepository.save(bookToSave);
            return new BookDto(savedNewBook);
        }else{
            throw new IllegalArgumentException("book is not found");
        }
    }

    public void deleteBookById(Integer bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        if(book.isPresent()){
            bookRepository.deleteById(bookId);
        }else{
            throw new IllegalArgumentException("book is not found");
        }
    }
}
