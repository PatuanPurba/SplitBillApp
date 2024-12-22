package use_case.create_group;

import java.util.UUID;

public class CreateGroupInputData {
    private final UUID userId;
    private final UUID token;
    private final String groupName;


    public CreateGroupInputData(UUID userId, String groupName, UUID token) {
        this.userId = userId;
        this.token = token;
        this.groupName = groupName;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getToken() {
        return token;
    }

    public String getGroupName() {return groupName;}
}
