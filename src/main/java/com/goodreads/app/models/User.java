package com.goodreads.app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class User implements Serializable {
    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    //Table connection between User and UserInGroup
    @OneToMany(mappedBy = "user")
    Set<UserInGroup> userInGroups;
    //Table connection between User and UserInCommunityGroup
    @OneToMany(mappedBy = "user")
    Set<UserInCommunityGroup> userInCommunityGroups;
    //Table connection between User and UserQuotes
    @OneToMany(mappedBy = "user")
    Set<UserQuotes> userQuotes;
    //Table connection between User and BookReview
    @OneToMany(mappedBy = "user")
    Set<BookReview> bookReviews;
    //Table connection between User and UserShelves
    @OneToMany(mappedBy = "user")
    Set<UserShelves> userShelves;
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
