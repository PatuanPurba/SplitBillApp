package com.SplitBill.service.delete_billing;

import com.SplitBill.data_transmission_object.DeleteBillingDTO;

public interface DeleteBillingServiceInterface {
    void execute(DeleteBillingDTO inputData);
}
