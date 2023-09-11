package com.example.perpustakaanonline.service.impl;

import com.example.perpustakaanonline.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.perpustakaanonline.repository.UserRepository;
import com.example.perpustakaanonline.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> checkIfExist(String email) {
        return userRepository.findById(email);
    }

    @Override
    public Optional<User> validateEmailAndPassword(String email, String password) {
        return userRepository.findUserByEmailAndPassword(email,password);
    }
}
