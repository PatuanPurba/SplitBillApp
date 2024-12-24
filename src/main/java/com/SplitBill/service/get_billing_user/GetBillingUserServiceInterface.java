package com.SplitBill.service.get_billing_user;

import com.SplitBill.data_transmission_object.BillingDTO;
import com.SplitBill.data_transmission_object.GetBillingDTO;

import java.util.List;

public interface GetBillingUserServiceInterface {
    List<BillingDTO> execute(GetBillingDTO inputData);
}
