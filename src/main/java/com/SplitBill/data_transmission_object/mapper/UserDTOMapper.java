package com.SplitBill.data_transmission_object.mapper;

import com.SplitBill.data_transmission_object.UserDTO;
import com.SplitBill.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserDTOMapper{

    public UserDTO create(User commonUser) {
        return new UserDTO(
                commonUser.getUsername(),
                commonUser.getFirstName(),
                commonUser.getLastName(),
                commonUser.getUserId()
        );
    }
}
