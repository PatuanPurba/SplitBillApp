package com.SplitBill.service.use_product;

import com.SplitBill.domain.*;
import com.SplitBill.repository.*;
import com.SplitBill.data_transmission_object.GroupDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UseProductInteractor implements UseProductInputBoundary{
    private final TokenRepository tokenRepository;
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final GroupProductRepository groupProductRepository;
    private final UserProductRepository userProductRepository;


    public UseProductInteractor(TokenRepository tokenRepository, GroupRepository groupRepository, UserRepository userRepository, ProductRepository productRepository, GroupProductRepository groupProductRepository, UserProductRepository userProductRepository) {
        this.tokenRepository = tokenRepository;
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.groupProductRepository = groupProductRepository;
        this.userProductRepository = userProductRepository;
    }

    @Override
    public GroupDTO execute(UseProductInputData inputData){
        try {
            if(!tokenRepository.existsById(inputData.getToken())){
                throw new Exception("Invalid Token");
            }


            String username = inputData.getUsername();
            String groupName = inputData.getGroupName();
            String productName = inputData.getProductName();
            int quantity = inputData.getQuantity();

            User user = userRepository.findByUsername(username);
            Group group = groupRepository.findByGroupName(groupName);
            Product product = productRepository.findByProductName(productName);

            System.out.println("Group_Id: " + group.getGroupId());
            System.out.println("Product_Id: " + product.getProductId());
            GroupProduct groupProduct = groupProductRepository.findByProduct_ProductIdAndGroup_GroupId(product.getProductId(), group.getGroupId());

            if (groupProduct.getQuantity() < quantity) {
                throw new Exception("Quantity demanded bigger than stock");
            }
            groupProduct.setQuantity(groupProduct.getQuantity() - quantity);

            float bill = product.getProductPrice() * quantity;

            UserProduct userProduct = new UserProduct(user, groupProduct, quantity, bill);
            System.out.println("Debug UseProduct 2");
            UserProduct savedUserProduct = userProductRepository.save(userProduct);
            System.out.println("Debug UseProduct 2");
            groupProduct.getUserProducts().add(savedUserProduct);
            groupProductRepository.save(groupProduct);

            return new GroupDTO(group.getGroupName(), group.getGroupId());

        }catch(Exception e){
            System.out.println("Error UseProduct: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
