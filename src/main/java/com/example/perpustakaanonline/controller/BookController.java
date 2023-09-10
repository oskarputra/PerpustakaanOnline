package com.example.perpustakaanonline.controller;

import com.example.perpustakaanonline.adapter.response.BaseResponse;
import com.example.perpustakaanonline.entity.Book;
import com.example.perpustakaanonline.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<BaseResponse> getBooks() {
        try{
            List<Book> books = bookRepository.findAll();

            return BaseResponse.generateSuccess(HttpStatus.OK, books);
        }catch(Exception e){
            return BaseResponse.generateError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
