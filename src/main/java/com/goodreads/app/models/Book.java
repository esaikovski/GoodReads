package com.goodreads.app.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Book implements Serializable {
    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    //Table connection between Book and BookReview
    @OneToMany(mappedBy = "book")
    Set<BookReview> bookReviews;
    //Table connection between User and UserShelves
    @OneToMany(mappedBy = "book")
    Set<UserShelves> userShelves;
    //@Column(nullable = false, updatable = false)
    private String title;
    //@Column(nullable = false, updatable = false)
    private String author;
    //@Column(nullable = false, updatable = false)
    private Integer isbn;
    //@Column(nullable = false, updatable = false)
    private Date published;
    //@Column(nullable = false, updatable = false)
    private String language;
    //@Column(nullable = false, updatable = false)
    private String genre;
    private String summary;
    private Date fromDate;
    private Date untilDate;
}
