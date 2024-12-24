package com.SplitBill.service.get_product_group;

import com.SplitBill.data_transmission_object.ProductDTO;
import com.SplitBill.data_transmission_object.StockDTO;
import com.SplitBill.data_transmission_object.get_product_group.GetProductGroupRequestDTO;
import com.SplitBill.data_transmission_object.mapper.ProductDTOMapper;
import com.SplitBill.domain.GroupProduct;
import com.SplitBill.repository.GroupProductRepository;
import com.SplitBill.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class GetProductGroupService implements GetProductGroupServiceInterface{
    private final GroupProductRepository groupProductRepository;
    private final ProductRepository productRepository;
    private final ProductDTOMapper mapper;

    public GetProductGroupService(GroupProductRepository groupProductRepository, ProductRepository productRepository, ProductDTOMapper mapper) {
        this.groupProductRepository = groupProductRepository;
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public StockDTO execute(GetProductGroupRequestDTO inputData) {
        UUID productId = inputData.productId();
        UUID groupId = inputData.groupId();

        if(groupProductRepository.existsByProduct_ProductIdAndGroup_GroupId(productId, groupId)) {
            GroupProduct groupProduct = groupProductRepository.findByProduct_ProductIdAndGroup_GroupId(productId, groupId);
            ProductDTO productDTO = mapper.map(productRepository.findById(groupProduct.getProduct().getProductId()).get());
            return new StockDTO(productDTO, groupProduct.getQuantity());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
    }
}
