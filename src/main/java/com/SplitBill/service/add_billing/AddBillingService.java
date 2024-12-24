package com.SplitBill.service.add_billing;

import com.SplitBill.data_transmission_object.AddBillingDTO;
import com.SplitBill.data_transmission_object.BillingDTO;
import com.SplitBill.domain.GroupProduct;
import com.SplitBill.domain.Product;
import com.SplitBill.domain.User;
import com.SplitBill.domain.UserProduct;
import com.SplitBill.repository.GroupProductRepository;
import com.SplitBill.repository.UserProductRepository;
import com.SplitBill.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class AddBillingService implements AddBillingServiceInterface {
    private final UserProductRepository userProductRepository;
    private final GroupProductRepository groupProductRepository;
    private final UserRepository userRepository;

    public AddBillingService(UserProductRepository userProductRepository, GroupProductRepository groupProductRepository, UserRepository userRepository) {
        this.userProductRepository = userProductRepository;
        this.groupProductRepository = groupProductRepository;
        this.userRepository = userRepository;
    }

    @Override
    public BillingDTO addBilling(AddBillingDTO inputData) {
        UUID userId = inputData.userId();
        UUID productId = inputData.productId();
        UUID groupId = inputData.groupId();
        int quantity = inputData.quantity();

        // Fetching Data from Databse
        if (!groupProductRepository.existsByProduct_ProductIdAndGroup_GroupId(productId, groupId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The group product is not valid");

        }
        if (!userRepository.existsById(userId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The user is not valid");
        }
        User user = userRepository.findById(userId).get();
        GroupProduct groupProduct = groupProductRepository.findByProduct_ProductIdAndGroup_GroupId(productId, groupId);

        //Applying Business Logic
        if(quantity > groupProduct.getQuantity() || quantity <= 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The quantity is not valid");
        }
        float bill = groupProduct.getProduct().getProductPrice() * quantity;
        groupProduct.setQuantity(groupProduct.getQuantity() - quantity);

        UserProduct userProduct = new UserProduct(null, user, groupProduct, quantity, bill, null);
        UserProduct newUserProduct = userProductRepository.save(userProduct);


        return new BillingDTO(newUserProduct.getUserProductId(), productId, groupProduct.getProduct().getProductName(),
                quantity, bill, newUserProduct.getDate());
    }
}
