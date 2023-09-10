package com.example.perpustakaanonline.repository;

import com.example.perpustakaanonline.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
