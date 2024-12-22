package use_case.create_group;

import java.util.UUID;

public class CreateGroupInputData {
    private final String username;
    private final UUID token;
    private final String groupName;


    public CreateGroupInputData(String username, String groupName, UUID token) {
        this.username = username;
        this.token = token;
        this.groupName = groupName;
    }

    public String getUsername() {
        return username;
    }

    public UUID getToken() {
        return token;
    }

    public String getGroupName() {return groupName;}
}
