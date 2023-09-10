package com.example.perpustakaanonline.util;

import java.util.regex.Pattern;

public class Util {

    public static boolean validateEmail(String email){
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        return Pattern.compile(regexPattern)
                .matcher(email)
                .matches();

    }

    public static boolean validatePassword(String password){
        String regexPattern= "^[a-zA-Z0-9]*$";
        String regexCapital = ".*[A-Z].*";

        if(password.length() < 8){
            return false;
        }

        if(!Pattern.compile(regexCapital)
                .matcher(password)
                .matches()){
            return false;
        }

        if(!Pattern.compile(regexPattern)
                .matcher(password)
                .matches()){
            return false;
        }

        return true;
    }
}
