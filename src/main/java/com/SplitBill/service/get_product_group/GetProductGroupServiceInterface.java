package com.SplitBill.service.get_product_group;

import com.SplitBill.data_transmission_object.StockDTO;
import com.SplitBill.data_transmission_object.get_product_group.GetProductGroupRequestDTO;

public interface GetProductGroupServiceInterface {
    StockDTO execute(GetProductGroupRequestDTO inputData);
}
