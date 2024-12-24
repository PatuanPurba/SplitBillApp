package com.SplitBill.service.create_group;

import com.SplitBill.data_transmission_object.create_group.CreateGroupRequestDTO;
import com.SplitBill.data_transmission_object.create_group.CreateGroupResponseDTO;

public interface CreateGroupServiceInterface {
    CreateGroupResponseDTO execute(CreateGroupRequestDTO inputData);
}
