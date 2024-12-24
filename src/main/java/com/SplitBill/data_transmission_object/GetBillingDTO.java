package com.SplitBill.data_transmission_object;

import java.util.UUID;

public record GetBillingDTO(UUID userId, UUID groupId) {
}
