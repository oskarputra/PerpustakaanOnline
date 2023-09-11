package com.example.perpustakaanonline.repository;

import com.example.perpustakaanonline.entity.BookTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookTransactionRepository extends JpaRepository<BookTransaction,String> {

    @Query(value = "SELECT *, 0 AS clazz_  FROM book_transaction WHERE user_email=?1 AND book_isbn=?2",nativeQuery = true)
    Optional<BookTransaction> findBookTransactionByUserAndBook(String email, String isbn);

    @Query(value = "SELECT *, 0 AS clazz_  FROM book_transaction WHERE user_email=?1",nativeQuery = true)
    Optional<BookTransaction> findBookTransactionByUser(String email);
}
