package com.example.perpustakaanonline.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "users")
@Data
@RequiredArgsConstructor
public class User {

    @Id
    private String email;
    private String password;
    private String name;
    private String phoneNumber;

    /*
    * 0 : Admin
    * 1 : User
    * */
    private int role;
}
