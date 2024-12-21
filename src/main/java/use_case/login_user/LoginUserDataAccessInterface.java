package use_case.login_user;

import entity.CommonUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUserDataAccessInterface extends JpaRepository<CommonUser, String> {
    boolean existsByUsername(String username);

    CommonUser findByUsername(String username);
}
