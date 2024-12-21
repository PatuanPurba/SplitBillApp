package use_case.login_user;

import entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoginTokenDataAccessInterface extends JpaRepository<Token, UUID> {
}
