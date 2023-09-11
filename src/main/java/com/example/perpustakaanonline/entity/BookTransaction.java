package com.example.perpustakaanonline.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "book_transaction")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@RequiredArgsConstructor
public class BookTransaction{

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
