package com.goodreads.app.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@Entity
public class UserGroup implements Serializable {
    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    //Table connection between UserGroup and UserInGroup
    @OneToMany(mappedBy = "userGroup")
    Set<UserInGroup> userInGroups;
    //Table connection between UserGroup and GroupsAction
    @OneToMany(mappedBy = "userGroup")
    Set<GroupsAction> groupsActions;
    //@Column(nullable = false)
    private String groupName;
    //@Column(nullable = false)
    private String description;
}
