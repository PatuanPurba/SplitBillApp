package com.SplitBill.service.add_billing;

import com.SplitBill.data_transmission_object.AddBillingDTO;
import com.SplitBill.data_transmission_object.BillingDTO;

public interface AddBillingServiceInterface {
    BillingDTO addBilling(AddBillingDTO inputData);
}
