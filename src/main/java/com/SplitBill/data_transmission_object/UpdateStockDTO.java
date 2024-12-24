package com.SplitBill.data_transmission_object;

import java.util.UUID;

public record UpdateStockDTO(UUID groupId, UUID productId, int quantity) {
}
