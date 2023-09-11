package com.example.perpustakaanonline.service;

import com.example.perpustakaanonline.entity.User;

import java.util.Optional;

public interface UserService {

    public User registerUser(User user);
    public Optional<User> checkIfExist(String email);

    public Optional<User> validateEmailAndPassword(String email, String password);

}
