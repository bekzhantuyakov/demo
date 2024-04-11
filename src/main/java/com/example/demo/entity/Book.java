package com.example.demo.entity;

import com.example.demo.dto.BookDto;
import jakarta.persistence.*;


@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Book() {

    }

    public Book(BookDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
    }

    public Book(Integer id,String name) {
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
