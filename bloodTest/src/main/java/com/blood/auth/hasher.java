package com.blood.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class hasher {
    public static void main(String[] args) {
        System.out.print(encryption("password"));
    }

    public static String encryption(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashed = passwordEncoder.encode(password);
        return hashed;
    }
}