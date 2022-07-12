package com.turing.javaee.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {
	 // Encode Password with BCryptPasswordEncoder
    public static String encodePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
 
    public static void main(String[] args) {
        String password = "admin";
        String encrytedPassword = encodePassword(password);
 
        System.out.println("Encoded Password: " + encrytedPassword);
    }
}
