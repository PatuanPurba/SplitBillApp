package data_transmission_object;

import java.util.UUID;

public class CreateGroupRequestDTO {
    private UUID userId;
    private String groupName;
    private UUID token;

    public CreateGroupRequestDTO(UUID userId, String groupName, UUID token) {
        this.userId = userId;
        this.groupName = groupName;
        this.token = token;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getGroupName() {
        return groupName;
    }

    public UUID getToken() {
        return token;
    }
}
