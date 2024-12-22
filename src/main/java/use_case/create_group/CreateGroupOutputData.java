package use_case.create_group;

import java.util.UUID;

public class CreateGroupOutputData {
    private UUID groupId;

    public CreateGroupOutputData(UUID groupId) {
        this.groupId = groupId;
    }

    public UUID getGroupId() {return groupId;}
}
