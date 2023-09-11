package com.example.perpustakaanonline.repository;

import com.example.perpustakaanonline.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {

    @Query(value = "SELECT *  FROM users WHERE email=?1 AND password=?2",nativeQuery = true)
    Optional<User> findUserByEmailAndPassword(String email, String password);
}
