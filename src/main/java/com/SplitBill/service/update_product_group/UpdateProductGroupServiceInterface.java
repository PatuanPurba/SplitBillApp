package com.SplitBill.service.update_product_group;

import com.SplitBill.data_transmission_object.StockDTO;
import com.SplitBill.data_transmission_object.UpdateStockDTO;

public interface UpdateProductGroupServiceInterface {
    StockDTO execute(UpdateStockDTO inputData);
}
