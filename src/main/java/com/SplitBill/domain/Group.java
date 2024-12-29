package com.SplitBill.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "groups")
public class Group{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID groupId;

    private String groupName;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    Set<UsersGroups> relationship = new HashSet<>();

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    Set<GroupProduct> products = new HashSet<>();

    public Group(String groupName) {
        this.groupId = null;
        this.groupName = groupName;
    }

    public Group() {}

    public UUID getGroupId() {return groupId;}

    public String getGroupName() {return groupName;}


    public Set<UsersGroups> getRelationship() {return relationship;}
    public Set<GroupProduct> getProducts() {return products;}


    public void addRelationship(UsersGroups relationship) {this.relationship.add(relationship);}
}
