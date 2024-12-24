package com.SplitBill.service.get_products_group;

import com.SplitBill.data_transmission_object.ProductDTO;
import com.SplitBill.data_transmission_object.StockDTO;
import com.SplitBill.data_transmission_object.mapper.ProductDTOMapper;
import com.SplitBill.domain.Group;
import com.SplitBill.domain.GroupProduct;
import com.SplitBill.domain.Product;
import com.SplitBill.repository.GroupProductRepository;
import com.SplitBill.service.product.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GetProductsGroupService implements GetProductsGroupServiceInterface{
    private final GroupProductRepository groupProductRepository;
    private final ProductService productService;
    private final ProductDTOMapper mapper;

    public GetProductsGroupService(GroupProductRepository groupProductRepository, ProductService productService, ProductDTOMapper mapper) {
        this.groupProductRepository = groupProductRepository;
        this.productService = productService;
        this.mapper = mapper;
    }

    @Override
    public List<StockDTO> execute(UUID groupId) {
        List<GroupProduct> listGP = groupProductRepository.getGroupProductByGroup_GroupId(groupId);

        List<StockDTO> stocks = new ArrayList<>();
        for(GroupProduct gp: listGP){
            stocks.add(new StockDTO(productService.get(gp.getProduct().getProductId()), gp.getQuantity()));
        }

        return stocks;
    }
}
