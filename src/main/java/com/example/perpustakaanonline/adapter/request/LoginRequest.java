package com.example.perpustakaanonline.adapter.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LoginRequest {

    private String email;
    private String password;
}
