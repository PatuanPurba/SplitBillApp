package data_transmission_object;

import java.util.UUID;

public class UserRequestDTO {
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private UUID token;

    public UserRequestDTO(String id, String username, String firstName, String lastName, String password, UUID token) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public UserRequestDTO(){}

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }
}
