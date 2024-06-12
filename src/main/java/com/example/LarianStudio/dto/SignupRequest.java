package com.example.LarianStudio.dto;

import lombok.Data;

@Data
public class SignupRequest {
    private String name;
    private int age;
    private String password;
    private String login;
}
