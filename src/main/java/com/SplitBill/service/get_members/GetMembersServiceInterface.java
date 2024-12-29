package com.SplitBill.service.get_members;

import com.SplitBill.data_transmission_object.UserDTO;

import java.util.List;
import java.util.UUID;

public interface GetMembersServiceInterface {
    List<UUID> execute(UUID groupId);
}
