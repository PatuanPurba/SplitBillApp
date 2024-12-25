package com.SplitBill.repository;

import com.SplitBill.data_transmission_object.BillingDTO;
import com.SplitBill.domain.UserProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UserProductRepository extends JpaRepository<UserProduct, UUID> {

    List<UserProduct> findAllByUser_userId(UUID userId);

    @Query(value = "SELECT new com.SplitBill.data_transmission_object.BillingDTO(up.userProductId, product.productId, product.productName, up.quantity, up.bill, up.date) " +
            "FROM UserProduct up JOIN GroupProduct gp ON up.groupProduct.gpId = gp.gpId " +
            "JOIN Product product ON gp.product.productId = product.productId " +
            "WHERE up.user.userId = :userId AND gp.group.groupId = :groupId")
    List<BillingDTO> findBillingDTOByUserIdAndGroupId(@Param("userId") UUID userId, @Param("groupId") UUID groupId);

    void deleteAllByUser_UserId(UUID userId);
}
