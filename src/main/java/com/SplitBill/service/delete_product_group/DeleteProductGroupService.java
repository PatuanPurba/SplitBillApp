package com.SplitBill.service.delete_product_group;

import com.SplitBill.data_transmission_object.DeleteStockDTO;
import com.SplitBill.repository.GroupProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteProductGroupService implements DeleteProductGroupServiceInterface{
    private final GroupProductRepository groupProductRepository;

    public DeleteProductGroupService(GroupProductRepository groupProductRepository) {
        this.groupProductRepository = groupProductRepository;
    }

    @Transactional
    @Override
    public void execute(DeleteStockDTO inputData) {
        UUID groupId = inputData.groupId();
        UUID productId = inputData.productId();

        groupProductRepository.deleteGroupProductByProduct_ProductIdAndGroup_GroupId(productId, groupId);
    }
}
