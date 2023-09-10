package com.example.perpustakaanonline.repository;

import com.example.perpustakaanonline.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,String> {
}
