package com.SplitBill.service.delete_product_group;

import com.SplitBill.data_transmission_object.DeleteStockDTO;

public interface DeleteProductGroupServiceInterface {
    void execute(DeleteStockDTO inputData);
}
