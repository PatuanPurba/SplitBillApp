package use_case.create_user;

import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CreateUserDataAccessInterface extends JpaRepository<User, String> {
    boolean existsByUsername(String username);
}
