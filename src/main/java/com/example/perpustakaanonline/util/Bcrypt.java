package com.example.perpustakaanonline.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

public class Bcrypt {

    private static int strength = 10; // work factor of bcrypt
    private static BCryptPasswordEncoder bCryptPasswordEncoder =
            new BCryptPasswordEncoder(strength, new SecureRandom());

    public static String hashPassword(String plainPassword){
        String encodedPassword = bCryptPasswordEncoder.encode(plainPassword);
        return encodedPassword;
    }

    public static Boolean validatePassword(String rawPassword, String encodedPassword){
        return bCryptPasswordEncoder.matches(rawPassword,encodedPassword);
    }


}
