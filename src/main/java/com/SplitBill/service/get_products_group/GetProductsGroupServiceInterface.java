package com.SplitBill.service.get_products_group;

import com.SplitBill.data_transmission_object.StockDTO;
import com.SplitBill.domain.Product;

import java.util.List;
import java.util.UUID;

public interface GetProductsGroupServiceInterface {
    List<StockDTO> execute(UUID groupId);
}
