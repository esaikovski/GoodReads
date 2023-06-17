package com.goodreads.app.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Book implements Serializable {
    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String title;
    private String author;
    private Integer isbn;
    private String published;
    private String language;
    private String genre;
    private String summary;
    private Date fromDate;
    private Date untilDate;
}
