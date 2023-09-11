package com.example.perpustakaanonline.controller;

import com.example.perpustakaanonline.adapter.request.BorrowBookRequest;
import com.example.perpustakaanonline.adapter.request.ReturnBookRequest;
import com.example.perpustakaanonline.adapter.response.BaseResponse;
import com.example.perpustakaanonline.entity.Book;
import com.example.perpustakaanonline.entity.BookTransaction;
import com.example.perpustakaanonline.entity.BookTransactionHistory;
import com.example.perpustakaanonline.entity.User;
import com.example.perpustakaanonline.repository.BookRepository;
import com.example.perpustakaanonline.repository.BookTransactionHistoryRepository;
import com.example.perpustakaanonline.repository.BookTransactionRepository;
import com.example.perpustakaanonline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transaction")
public class BookTransactionController {

    @Autowired
    private BookTransactionRepository bookTransactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookTransactionHistoryRepository bookTransactionHistoryRepository;


    @GetMapping
    public ResponseEntity<BaseResponse> getBorrowedBooks() {
        try{
            List<BookTransaction> borrowedBooks = bookTransactionRepository.findAll();

            return BaseResponse.generateSuccess(HttpStatus.OK, borrowedBooks);
        }catch(Exception e){
            return BaseResponse.generateError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping("/borrow")
    public ResponseEntity<BaseResponse> borrowBook(@RequestBody BorrowBookRequest request) {
        try{

            Optional<BookTransaction> transaction = bookTransactionRepository.findBookTransactionByUser(request.getEmail());
            if(transaction.isPresent()){
                return BaseResponse.generateError(HttpStatus.BAD_REQUEST, "Can't borrow more book");
            }

            Optional<User> user = userRepository.findById(request.getEmail());
            Optional<Book> book = bookRepository.findById(request.getIsbn());

            if(user.isEmpty()){
                return BaseResponse.generateError(HttpStatus.BAD_REQUEST, "User not found");
            }

            if(book.isEmpty()){
                return BaseResponse.generateError(HttpStatus.BAD_REQUEST, "Book not found");
            }

            BookTransaction bookTransaction = new BookTransaction();

            bookTransaction.setBook(book.get());
            bookTransaction.setUser(user.get());
            bookTransaction.setBorrowDate(new Date());

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            bookTransaction.setReturnDate(dateFormat.parse(request.getReturnDate()));

            bookTransaction.setReturn(false);

            BookTransaction result = bookTransactionRepository.save(bookTransaction);

            return BaseResponse.generateSuccess(HttpStatus.OK, result);
        }catch(Exception e){
            return BaseResponse.generateError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping("/return")
    public ResponseEntity<BaseResponse> returnBook(@RequestBody ReturnBookRequest request) {
        try{

            Optional<BookTransaction> result = bookTransactionRepository.findBookTransactionByUserAndBook(request.getEmail(), request.getIsbn());
            if(result.isEmpty()){
                return BaseResponse.generateError(HttpStatus.BAD_REQUEST, "Transaction not found");
            }

            BookTransactionHistory bookTransactionHistory = new BookTransactionHistory();
            bookTransactionHistory.setTransactionId(result.get().getTransactionId());
            bookTransactionHistory.setBook(result.get().getBook());
            bookTransactionHistory.setUser(result.get().getUser());
            bookTransactionHistory.setBorrowDate(result.get().getBorrowDate());
            bookTransactionHistory.setReturnDate(new Date());
            bookTransactionHistory.setReturn(true);

            bookTransactionHistoryRepository.save(bookTransactionHistory);
            bookTransactionRepository.delete(result.get());

            return BaseResponse.generateSuccess(HttpStatus.OK, result);
        }catch(Exception e){
            return BaseResponse.generateError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }


}
