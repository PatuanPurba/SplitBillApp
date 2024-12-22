package data_transmission_object;

import entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserDTOMapper{

    public UserDTO create(User commonUser) {
        return new UserDTO(
                commonUser.getUsername(),
                commonUser.getFirstName(),
                commonUser.getLastName()
        );
    }
}
