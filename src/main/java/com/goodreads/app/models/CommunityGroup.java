package com.goodreads.app.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@Entity
public class CommunityGroup implements Serializable {
    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    //Table connection between CommunityGroup and UserInCommunityGroup
    @OneToMany(mappedBy = "communityGroup")
    Set<UserInCommunityGroup> userInCommunityGroups;
    //@Column(nullable = false, updatable = false)
    private String name;
    //@Column(nullable = false, updatable = false)
    private String description;

}
