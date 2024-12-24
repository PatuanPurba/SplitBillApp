package com.SplitBill.repository;

import com.SplitBill.domain.GroupProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GroupProductRepository extends JpaRepository<GroupProduct, UUID> {
    boolean existsByProduct_ProductIdAndGroup_GroupId(UUID product_productId, UUID group_groupId);

    GroupProduct findByProduct_ProductIdAndGroup_GroupId(UUID productId, UUID groupId);

    List<GroupProduct> getGroupProductByGroup_GroupId(UUID groupId);

    void deleteGroupProductByProduct_ProductIdAndGroup_GroupId(UUID product_productId, UUID groupId);
}
