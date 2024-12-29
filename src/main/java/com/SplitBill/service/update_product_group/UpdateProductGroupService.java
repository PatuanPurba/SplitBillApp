package com.SplitBill.service.update_product_group;

import com.SplitBill.data_transmission_object.StockDTO;
import com.SplitBill.data_transmission_object.UpdateStockDTO;
import com.SplitBill.domain.GroupProduct;
import com.SplitBill.repository.GroupProductRepository;
import com.SplitBill.service.general_service.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class UpdateProductGroupService implements UpdateProductGroupServiceInterface{
    private GroupProductRepository groupProductRepository;
    private ProductService productService;

    public UpdateProductGroupService(GroupProductRepository groupProductRepository, ProductService productService) {
        this.groupProductRepository = groupProductRepository;
        this.productService = productService;
    }

    @Override
    public StockDTO execute(UpdateStockDTO inputData) {
        UUID groupId = inputData.groupId();
        UUID productId = inputData.productId();
        if(groupProductRepository.existsByProduct_ProductIdAndGroup_GroupId(productId, groupId)){
            GroupProduct groupProduct = groupProductRepository.findByProduct_ProductIdAndGroup_GroupId(productId, groupId);
            groupProduct.setQuantity(inputData.quantity());
            groupProductRepository.save(groupProduct);
            return new StockDTO(productService.get(productId), inputData.quantity());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found the Product");
    }
}
