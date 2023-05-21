package com.goodreads.app.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Quote implements Serializable {
    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    //Table connection between Quotes and UserQuotes
    @OneToMany(mappedBy = "quote")
    Set<UserQuotes> userQuotes;
    private String quote;
    private Date fromDate;
    private Date untilDate;
}
