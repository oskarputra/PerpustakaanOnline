package com.example.perpustakaanonline.adapter.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserRegistrationRequest {

    private String email;
    private String password;
    private String name;
    private String phoneNumber;
}
