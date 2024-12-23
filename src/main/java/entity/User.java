package entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    private String username;
    private String firstName;
    private String LastName;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UsersGroups> relationship = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserProduct> products = new HashSet<>();

    public User(UUID userId, String username, String password, String firstName, String LastName) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.LastName = LastName;
    }

    public User(UUID userId, String username, String password, String firstName, String LastName, Set<UsersGroups> relationship) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.LastName = LastName;
        this.relationship = relationship;
    }

    public User() {
    }

    public UUID getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPassword() {
        return password;
    }

    public Set<UsersGroups> getRelationship() {return relationship;}

    public Set<UserProduct> getProducts() {
        return products;
    }
}
