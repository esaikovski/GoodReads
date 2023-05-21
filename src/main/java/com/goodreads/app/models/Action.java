package com.goodreads.app.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@Entity
public class Action implements Serializable {
    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    //Table connection between Action and GroupsAction
    @OneToMany(mappedBy = "action")
    Set<GroupsAction> groupsActions;
    //@Column(nullable = false)
    private String name;
    //@Column(nullable = false)
    private String description;
}
