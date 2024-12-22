package use_case.login_user;

import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUserDataAccessInterface extends JpaRepository<User, String> {
    boolean existsByUsername(String username);

    User findByUsername(String username);
}
