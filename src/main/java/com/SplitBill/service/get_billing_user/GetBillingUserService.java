package com.SplitBill.service.get_billing_user;

import com.SplitBill.data_transmission_object.BillingDTO;
import com.SplitBill.data_transmission_object.GetBillingDTO;
import com.SplitBill.data_transmission_object.mapper.ProductDTOMapper;
import com.SplitBill.repository.ProductRepository;
import com.SplitBill.repository.UserProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetBillingUserService implements GetBillingUserServiceInterface{

    private final UserProductRepository userProductRepository;
    private final ProductRepository productRepository;
    private final ProductDTOMapper mapper;

    public GetBillingUserService(UserProductRepository userProductRepository, ProductRepository productRepository, ProductDTOMapper mapper) {
        this.userProductRepository = userProductRepository;
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public List<BillingDTO> execute(GetBillingDTO inputData) {
        UUID groupId = inputData.groupId();
        UUID userId = inputData.userId();
        List<BillingDTO> billings = userProductRepository.findBillingDTOByUserIdAndGroupId(userId, groupId);
        System.out.println("billings" + billings);
        return billings;
    }
}
