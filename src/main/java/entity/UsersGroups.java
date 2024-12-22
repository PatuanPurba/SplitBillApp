package entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users_groups")
public class UsersGroups {
    @EmbeddedId
    UsersGroupsId id;

    @ManyToOne
    @MapsId ("userId")
    @JoinColumn(name = "user_id")
    CommonUser user;

    @ManyToOne
    @MapsId ("groupId")
    @JoinColumn(name = "group_id")
    CommonGroup group;

    public UsersGroups(UsersGroupsId id) {
        this.id = id;
    }

    public UsersGroups() {}

    public UsersGroupsId getId() {return id;}

    public void setUser(CommonUser user) {this.user = user;}

    public void setGroup(CommonGroup group) {this.group = group;}
}
