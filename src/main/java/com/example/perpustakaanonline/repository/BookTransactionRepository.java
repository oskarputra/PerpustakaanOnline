package com.example.perpustakaanonline.repository;

import com.example.perpustakaanonline.entity.BookTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookTransactionRepository extends JpaRepository<BookTransaction,String> {
}
