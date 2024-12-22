package use_case.logout;

import java.util.UUID;

public class LogOutInputData {
    private String username;
    private UUID token;

    public LogOutInputData(String username, UUID token) {
        this.token = token;
        this.username = username;
    }

    public String getUsername() {return username;}
    public UUID getToken() {return token;}
}
