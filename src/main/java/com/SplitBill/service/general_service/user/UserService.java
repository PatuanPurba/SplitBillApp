package com.SplitBill.service.general_service.user;

import com.SplitBill.data_transmission_object.UserDTO;
import com.SplitBill.data_transmission_object.mapper.UserDTOMapper;
import com.SplitBill.domain.User;
import com.SplitBill.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDTOMapper mapper;


    public UserService(UserRepository userRepository, UserDTOMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public List<UserDTO> getUsers(List<UUID> userIds){
        List<UserDTO> result = new ArrayList<>();
        List<String> error = new ArrayList<>();

        for (UUID userId : userIds) {
            User user = userRepository.findById(userId).orElse(null);
            if(user != null){
                result.add(mapper.create(user));
            }
            else{
                error.add("Id: " + userId + " not found");
            }
        }
        return result;
    }

    public UserDTO getUser(UUID userId){
        User user = userRepository.findById(userId).orElse(null);
        if (user != null){
            return mapper.create(user);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }
}
