package data_transmission_object;

import java.util.UUID;

public class CreateGroupResponseDTO {
    private String message;
    private UUID groupId;

    public CreateGroupResponseDTO(String message, UUID groupId) {
        this.message = message;
        this.groupId = groupId;
    }

    public String getMessage() {return message;}

    public UUID getGroupId() {return groupId;}
}
