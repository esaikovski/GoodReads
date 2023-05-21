package com.goodreads.app.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class UserQuotes implements Serializable {
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
    @JoinColumn(name = "quote_id")
    Quote quote;
    private Date fromDate;
    private Date untilDate;
}
