package com.example.perpustakaanonline.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "books")
@Data
@RequiredArgsConstructor
public class Book {

    @Id
    private String isbn;
    private String name;
    private String author;
    private String publisher;
    private String year;
}
