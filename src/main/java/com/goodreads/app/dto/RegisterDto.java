package com.goodreads.app.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String email;
    private String username;
    private String fullName;
    private String password;

}
