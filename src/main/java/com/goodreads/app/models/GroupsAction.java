package com.goodreads.app.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class GroupsAction implements Serializable {
    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    //Foreign key 1
    @ManyToOne
    @JoinColumn(name = "userGroup_id")
    UserGroup userGroup;
    //Foreign key 2
    @ManyToOne
    @JoinColumn(name = "action_id")
    Action action;
    //@Column(nullable = false)
    private Date fromDate;
    private Date untilDate;
}
