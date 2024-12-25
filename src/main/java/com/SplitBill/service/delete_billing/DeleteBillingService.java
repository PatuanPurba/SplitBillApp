package com.SplitBill.service.delete_billing;

import com.SplitBill.data_transmission_object.DeleteBillingDTO;
import com.SplitBill.repository.UserProductRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteBillingService implements DeleteBillingServiceInterface {
    private final UserProductRepository userProductRepository;

    public DeleteBillingService(UserProductRepository userProductRepository) {
        this.userProductRepository = userProductRepository;
    }


    @Override
    public void execute(DeleteBillingDTO inputData) {
        UUID groupId = inputData.groupId();
        UUID userId = inputData.userId();

        userProductRepository.deleteAllByUser_UserId(userId);
    }
}
