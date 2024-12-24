package com.SplitBill.data_transmission_object;

import com.SplitBill.domain.Product;
import org.hibernate.cache.spi.support.SimpleTimestamper;

import java.sql.Timestamp;
import java.util.UUID;

public record BillingDTO(
        UUID userProductId,
        UUID productId,
        String productName,
        int quantity,
        float totalBilling,
        Timestamp date
) {

}
