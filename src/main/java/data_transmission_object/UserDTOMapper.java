package data_transmission_object;

import entity.CommonUser;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDTOMapper{

    public UserDTO create(CommonUser commonUser) {
        return new UserDTO(
                commonUser.getUsername(),
                commonUser.getFirstName(),
                commonUser.getLastName()
        );
    }
}
