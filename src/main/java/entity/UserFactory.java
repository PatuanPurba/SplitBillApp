package entity;

import jakarta.persistence.Entity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public interface UserFactory {
    User create(UUID user_id, String first_name, String last_name, String username, String Password);

    User create(String first_name, String last_name, String username, String password);
}
