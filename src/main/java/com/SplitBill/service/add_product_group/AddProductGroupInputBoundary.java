package com.SplitBill.service.add_product_group;

import com.SplitBill.data_transmission_object.AddStockDTO;
import com.SplitBill.data_transmission_object.ProductDTO;

public interface AddProductGroupInputBoundary {
    ProductDTO execute(AddStockDTO inputData);
}
