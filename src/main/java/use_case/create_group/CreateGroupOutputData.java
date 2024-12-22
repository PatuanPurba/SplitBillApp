package use_case.create_group;

import java.util.UUID;

public class CreateGroupOutputData {
    private String groupName;

    public CreateGroupOutputData(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupId() {return groupName;}
}
