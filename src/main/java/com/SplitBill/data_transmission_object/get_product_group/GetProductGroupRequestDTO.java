package com.SplitBill.data_transmission_object.get_product_group;

import java.util.UUID;

public record GetProductGroupRequestDTO(UUID groupId, UUID productId) {
}
