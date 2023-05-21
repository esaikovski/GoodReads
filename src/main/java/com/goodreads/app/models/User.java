package com.goodreads.app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false, updatable = false)
    private String username;
    // Spring Security password handling?
    //@Column(nullable = false)
    private String password;
    //@Column(nullable = false)
    private String name;
    private String middleName;
    //@Column(nullable = false)
    private String sureName;
    //@Column(nullable = false)
    private String email;
    //@Column(nullable = false)
    private Character gender;
    private String address;
    //Date formatting required?
    private Date dateOfBirth;
    private String phoneNumber;
    private String aboutMe;
    private String myInterests;

}
