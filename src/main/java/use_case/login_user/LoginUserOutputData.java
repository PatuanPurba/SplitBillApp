package use_case.login_user;

import entity.User;

import java.util.UUID;

public class LoginUserOutputData {
    private final User user;
    private final UUID token;


    public LoginUserOutputData(User user, UUID token) {
        this.user = user;
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public UUID getToken() {
        return token;
    }
}
