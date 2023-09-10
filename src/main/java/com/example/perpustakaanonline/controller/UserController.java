package com.example.perpustakaanonline.controller;

import com.example.perpustakaanonline.adapter.request.UserRegistrationRequest;
import com.example.perpustakaanonline.adapter.response.BaseResponse;
import com.example.perpustakaanonline.entity.User;
import com.example.perpustakaanonline.service.UserService;
import com.example.perpustakaanonline.util.Bcrypt;
import com.example.perpustakaanonline.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<BaseResponse> registerUser(@RequestBody UserRegistrationRequest request){
        try{

            if(!Util.validateEmail(request.getEmail())){
                return BaseResponse.generateError(HttpStatus.BAD_REQUEST, "Please provide a valid email address");
            }

            if(!Util.validatePassword(request.getPassword())){
                return BaseResponse.generateError(HttpStatus.BAD_REQUEST, "Password not valid. Min 8 characters with atleast 1 capital and no special character");
            }

            if(userService.checkIfExist(request.getEmail()).isPresent()){
                return BaseResponse.generateError(HttpStatus.CONFLICT, "Email already exist");
            }

            User user = new User();
            user.setEmail(request.getEmail());
            user.setName(request.getName());
            user.setPassword(Bcrypt.hashPassword(request.getPassword()));
            user.setPhoneNumber(request.getPhoneNumber());

            //user
            user.setRole(0);
            User registeredUser = userService.registerUser(user);
            return BaseResponse.generateSuccess(HttpStatus.CREATED, registeredUser);

        }catch(Exception e){
            return BaseResponse.generateError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

    }
}
