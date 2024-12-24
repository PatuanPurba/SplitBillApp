package com.SplitBill.data_transmission_object.create_group;

import java.util.UUID;

public record CreateGroupRequestDTO(UUID userId, String groupName) {
}
