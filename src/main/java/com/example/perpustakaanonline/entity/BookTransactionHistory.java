package com.example.perpustakaanonline.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "book_transaction_history")
@Data
@RequiredArgsConstructor
public class BookTransactionHistory {

    @Id
    @GeneratedValue
    private long transactionId;

    @OneToOne
    private User user;

    @OneToOne
    private Book book;

    private Date borrowDate;

    private Date returnDate;

    private boolean isReturn;
}
