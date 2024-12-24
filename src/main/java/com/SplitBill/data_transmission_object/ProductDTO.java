package com.SplitBill.data_transmission_object;

import java.util.UUID;

public record ProductDTO(
        UUID productId,
        String productName,
        float price
) {
}
