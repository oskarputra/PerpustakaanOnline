package com.example.perpustakaanonline.adapter.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BorrowBookRequest {

    private String email;
    private String isbn;
    private String returnDate;
}
