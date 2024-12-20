package entity;

import java.util.List;

public class CommonUser implements User{
    private String userId;
    private String username;
    private String firstName;
    private String lastName;
    private List<String> groups;

    public CommonUser(String userId, String username, String firstName, String lastName, List<String> groups) {
        this.userId = userId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.groups = groups;
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public List<String> getGroups() {
        return groups;
    }
}
