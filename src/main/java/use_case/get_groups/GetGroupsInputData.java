package use_case.get_groups;

import java.util.UUID;

public class GetGroupsInputData {
    String username;
    UUID token;

    public GetGroupsInputData(String username, UUID token) {
        this.username = username;
        this.token = token;
    }

    public String getUsername() {return username;}
    public UUID getToken() {return token;}
}
