package com.SplitBill.api;

// Controller to manage the relation between user and product (Billing)

import com.SplitBill.data_transmission_object.AddBillingDTO;
import com.SplitBill.data_transmission_object.BillingDTO;
import com.SplitBill.data_transmission_object.DeleteBillingDTO;
import com.SplitBill.data_transmission_object.GetBillingDTO;
import com.SplitBill.service.add_billing.AddBillingService;
import com.SplitBill.service.delete_billing.DeleteBillingService;
import com.SplitBill.service.get_billing_user.GetBillingUserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user/user_product")
public class BillingController {
    @Autowired
    private GetBillingUserServiceInterface getBillingService;

    @Autowired
    private AddBillingService addBillingService;

    @Autowired
    private DeleteBillingService deleteBillingService;

    @GetMapping
    public List<BillingDTO> getBilling(@RequestBody GetBillingDTO request){
        return getBillingService.execute(request);
    }

    @PostMapping
    public BillingDTO addBilling(@RequestBody AddBillingDTO request){
        return addBillingService.addBilling(request);
    }

    @DeleteMapping
    public void deleteBilling(@RequestBody DeleteBillingDTO request){
        deleteBillingService.execute(request);
    }
}
