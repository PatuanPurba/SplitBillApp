package com.SplitBill.service.add_product_group;

import com.SplitBill.data_transmission_object.AddStockDTO;
import com.SplitBill.data_transmission_object.ProductDTO;
import com.SplitBill.data_transmission_object.mapper.ProductDTOMapper;
import com.SplitBill.domain.Group;
import com.SplitBill.domain.GroupProduct;
import com.SplitBill.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.SplitBill.repository.GroupProductRepository;
import com.SplitBill.repository.GroupRepository;
import com.SplitBill.repository.ProductRepository;
import com.SplitBill.repository.TokenRepository;

import java.util.UUID;

@Service
public class AddProductGroupInteractor implements AddProductGroupInputBoundary{
    private final GroupRepository groupRepository;
    private final ProductRepository productRepository;
    private final GroupProductRepository groupProductRepository;
    private final ProductDTOMapper mapper;

    public AddProductGroupInteractor(GroupRepository groupRepository, ProductRepository productRepository, GroupProductRepository groupProductRepository, ProductDTOMapper mapper) {
        this.groupRepository = groupRepository;
        this.productRepository = productRepository;
        this.groupProductRepository = groupProductRepository;
        this.mapper = mapper;
    }



    @Override
    public ProductDTO execute(AddStockDTO inputData) {
        try {
            if(inputData.quantity() <= 0){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantity must be greater than 0");
            }
            if(!productRepository.existsById(inputData.productId())) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found");
            }

            if(!groupRepository.existsById(inputData.groupId())){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group Not Found");
            }

            UUID productId = inputData.productId();
            UUID groupId = inputData.groupId();
            int quantity = inputData.quantity();
            Product product  = productRepository.findById(productId).orElse(null);

            if (groupProductRepository.existsByProduct_ProductIdAndGroup_GroupId(productId, groupId)) {
                GroupProduct groupProduct = groupProductRepository.findByProduct_ProductIdAndGroup_GroupId(productId, groupId);
                groupProduct.setQuantity(groupProduct.getQuantity() + quantity);
                groupProductRepository.save(groupProduct);
            }
            else{
                Group group = groupRepository.findById(inputData.groupId()).get();

                GroupProduct groupProduct = new GroupProduct(group, product, inputData.quantity());
                groupProductRepository.save(groupProduct);
            }

            return mapper.map(product);

        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }


    }
}
