package use_case.create_user;

import entity.CommonUser;
import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository

public interface CreateUserDataAccessInterface extends JpaRepository<CommonUser, String> {
    boolean existsByUsername(String username);
}
