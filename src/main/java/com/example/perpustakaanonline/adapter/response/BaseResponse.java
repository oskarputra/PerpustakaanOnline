package com.example.perpustakaanonline.adapter.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

@Builder
@AllArgsConstructor
@Data
public class BaseResponse {

    private boolean success;
    private String message;
    private Object data;

    public static ResponseEntity<BaseResponse> generateSuccess(HttpStatus httpStatus, Object data){
        return new ResponseEntity<>(BaseResponse.builder().
                success(true).
                message("success").
                data(data).build(), httpStatus);
    }

    public static ResponseEntity<BaseResponse> generateError(HttpStatus httpStatus, String errorMessage){
        return new ResponseEntity<>(BaseResponse.builder().
                success(false).
                message(errorMessage).
                data(new ArrayList<>()).build(), httpStatus);
    }
}
