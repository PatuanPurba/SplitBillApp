package com.SplitBill.service.get_groups;

import com.SplitBill.data_transmission_object.GroupDTO;

import java.util.List;
import java.util.UUID;

public interface GetGroupsServiceInterface {
    List<GroupDTO> execute(UUID userId);
}
