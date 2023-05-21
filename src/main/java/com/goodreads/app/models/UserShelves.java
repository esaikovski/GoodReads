package com.goodreads.app.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class UserShelves implements Serializable {
    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    //Foreign key 1
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
    //Foreign key 2
    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;
    //Foreign key 3
    @ManyToOne
    @JoinColumn(name = "bookshelf_id")
    BookShelf bookShelf;
    //@Column(nullable = false)
    private Date fromDate;
    private Date untilDate;

}
