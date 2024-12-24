package com.SplitBill.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "users_groups")
public class UsersGroups {
    @EmbeddedId
    UsersGroupsId id;

    @ManyToOne
    @MapsId ("userId")
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @MapsId ("groupId")
    @JoinColumn(name = "group_id")
    Group group;

    public UsersGroups(UsersGroupsId id) {
        this.id = id;
    }

    public UsersGroups() {}

    public UsersGroupsId getId() {return id;}

    public void setUser(User user) {this.user = user;}

    public void setGroup(Group group) {this.group = group;}

    public Group getGroup() {return group;}
}
