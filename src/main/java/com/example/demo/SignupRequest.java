package com.example.demo;

import lombok.Getter;

@Getter
public class SignupRequest {
    private String email;
    private String password;
    private String role;
}