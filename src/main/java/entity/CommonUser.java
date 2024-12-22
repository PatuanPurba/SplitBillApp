package entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class CommonUser implements User{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    private String username;
    private String firstName;
    private String LastName;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UsersGroups> relationship = new HashSet<>();

    public CommonUser(UUID userId, String username, String password, String firstName, String LastName) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.LastName = LastName;
    }

    public CommonUser(UUID userId, String username, String password, String firstName, String LastName, Set<UsersGroups> relationship) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.LastName = LastName;
        this.relationship = relationship;
    }

    public CommonUser() {
    }

    public UUID getUserId() {
        return userId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public Set<UsersGroups> getRelationship() {return relationship;}
}
