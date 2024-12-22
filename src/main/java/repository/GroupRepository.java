package repository;

import entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<Group, UUID> {

    @Query(value = "SELECT case when count(ug) > 0 from users_groups where user_id = userId AND group_id = group_id", nativeQuery = true)
    boolean existByUserIdGroupId(UUID userId, UUID groupId);

    Group findByGroupName(String groupName);

}
