package repository;

import entity.GroupProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GroupProductRepository extends JpaRepository<GroupProduct, UUID> {
}
