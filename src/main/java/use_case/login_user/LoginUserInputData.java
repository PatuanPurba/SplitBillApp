package use_case.login_user;

public class LoginUserInputData {
    private final String username;
    private final String password;


    public LoginUserInputData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
