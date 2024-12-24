package com.SplitBill.service.use_product;

import com.SplitBill.data_transmission_object.GroupDTO;

public interface UseProductInputBoundary {
    GroupDTO execute(UseProductInputData inputData);
}
