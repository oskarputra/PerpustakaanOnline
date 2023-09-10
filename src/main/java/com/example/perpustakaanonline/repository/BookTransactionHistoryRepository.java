package com.example.perpustakaanonline.repository;

import com.example.perpustakaanonline.entity.BookTransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookTransactionHistoryRepository extends JpaRepository<BookTransactionHistory,String> {
}
