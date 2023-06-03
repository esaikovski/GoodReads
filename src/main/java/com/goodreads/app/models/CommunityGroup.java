package com.goodreads.app.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class CommunityGroup implements Serializable {
    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    //@Column(nullable = false, updatable = false)
    private String name;
    //@Column(nullable = false, updatable = false)
    private String description;

}
