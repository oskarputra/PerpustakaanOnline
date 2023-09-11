package com.example.perpustakaanonline.repository;

import com.example.perpustakaanonline.entity.BookTransaction;
import com.example.perpustakaanonline.entity.BookTransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookTransactionHistoryRepository extends JpaRepository<BookTransactionHistory,String> {

    @Query(value = "SELECT *, 0 AS clazz_  FROM book_transaction_history WHERE user_email=?1 AND book_isbn=?2",nativeQuery = true)
    Optional<BookTransaction> findBookTransactionByUserAndBook(String email, String isbn);
}
