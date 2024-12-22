package entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "groups")
public class CommonGroup implements Group{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID groupId;

    private String groupName;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    Set<UsersGroups> relationship = new HashSet<>(); ;

    public CommonGroup(String groupName) {
        this.groupName = groupName;
    }

    public CommonGroup() {}

    public UUID getGroupId() {return groupId;}

    public String getGroupName() {return groupName;}


    public Set<UsersGroups> getRelationship() {return relationship;}


    public void addRelationship(UsersGroups relationship) {this.relationship.add(relationship);}
}
