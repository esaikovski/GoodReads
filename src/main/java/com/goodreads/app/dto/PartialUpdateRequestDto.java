package com.goodreads.app.dto;

import lombok.Data;
@Data
public class PartialUpdateRequestDto {
    private String username;
    private String password;
    private String fullName;
    private String email;
    private Character gender;
    private String address;
    private String aboutMe;
}
