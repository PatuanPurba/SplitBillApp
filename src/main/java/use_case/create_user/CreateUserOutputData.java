package use_case.create_user;

import java.util.UUID;

public class CreateUserOutputData {
    private String first_name;
    private String last_name;
    private String username;
    private UUID user_id;
    private String errorMessage;

    public CreateUserOutputData(String first_name, String last_name, String username, UUID user_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.user_id = user_id;
    }

    public CreateUserOutputData() {}

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getUsername() {
        return username;
    }

    public UUID getUser_id() {return user_id;}

    public String getErrorMessage() {return errorMessage;}

    public void setErrorMessage(String errorMessage) {this.errorMessage = errorMessage;}
}
