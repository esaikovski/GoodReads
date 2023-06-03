package com.goodreads.app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "users")
@Entity
public class UserEntity implements Serializable {
    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String username;
    //@Column(nullable = false)
    private String password;
    //@Column(nullable = false)
    private String name;
    private String middleName;
    //@Column(nullable = false)
    private String surname;
    //@Column(nullable = false)
    private String email;
    //@Column(nullable = false)
    private Character gender;
    private String address;
    //Date formatting required? date?
    private Integer dateOfBirth;
    private String phoneNumber;
    private String aboutMe;
    private String myInterests;
    //Many-to-many table connection with join table between UserEntity and UserShelves class
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_shelves", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_shelf_id",referencedColumnName = "id"))
    private List<BookShelf> bookShelves = new ArrayList<>();

    //Many-to-many table connection with join table between UserEntity and BookReview class
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "book_review", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_id",referencedColumnName = "id"))
    private List<Book> books = new ArrayList<>();

    //Many-to-many table connection with join table between UserEntity and UserQuotes class
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_quotes", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "quote_id",referencedColumnName = "id"))
    private List<Quote> quotes = new ArrayList<>();

    //Many-to-many table connection with join table between UserEntity and CommunityGroup class
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_in_community_group", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "community_group_id",referencedColumnName = "id"))
    private List<CommunityGroup> communityGroups = new ArrayList<>();

    //Many-to-many table connection with join table between UserEntity and Role class
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_in_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private List<Role> roles = new ArrayList<>();


}
