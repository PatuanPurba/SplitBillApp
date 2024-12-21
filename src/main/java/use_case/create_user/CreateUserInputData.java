package use_case.create_user;

public class CreateUserInputData {
    private final String first_name;
    private final String last_name;
    private final String username;
    private final String password;

    public CreateUserInputData(String first_name, String last_name, String username, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;

    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
