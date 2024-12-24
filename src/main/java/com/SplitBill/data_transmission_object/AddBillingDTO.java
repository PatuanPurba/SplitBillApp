package com.SplitBill.data_transmission_object;

import java.util.UUID;

public record AddBillingDTO(UUID userId, UUID groupId, UUID productId, int quantity) {
}
