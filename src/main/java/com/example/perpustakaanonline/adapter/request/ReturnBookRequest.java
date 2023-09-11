package com.example.perpustakaanonline.adapter.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ReturnBookRequest {

    private String email;
    private String isbn;

}
