package com.example.demo.dto;

import com.example.demo.entity.Book;

public class BookDto {

    private Integer id;
    private String name;

    public BookDto() {
    }

    public BookDto(Book book) {
        this.id = book.getId();
        this.name = book.getName();
    }

    public BookDto(Integer id,String name) {
        this.id = id;
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


