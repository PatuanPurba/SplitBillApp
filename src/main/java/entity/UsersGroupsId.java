package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class UsersGroupsId implements Serializable {

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "group_id")
    private UUID groupId;

    public UsersGroupsId(UUID userId, UUID groupId) {
        this.userId = userId;
        this.groupId = groupId;
    }

    public UsersGroupsId() {}
}
