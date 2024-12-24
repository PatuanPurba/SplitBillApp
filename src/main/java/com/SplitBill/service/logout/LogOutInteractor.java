package com.SplitBill.service.logout;

import com.SplitBill.data_transmission_object.UserDTO;
import com.SplitBill.data_transmission_object.mapper.UserDTOMapper;
import com.SplitBill.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.SplitBill.repository.GroupRepository;
import com.SplitBill.repository.TokenRepository;
import com.SplitBill.repository.UserRepository;

import java.util.UUID;

@Service
public class LogOutInteractor implements LogOutInputBoundary{
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final TokenRepository tokenRepository;
    private final UserDTOMapper mapper;


    public LogOutInteractor(UserRepository userRepository, GroupRepository groupRepository, TokenRepository tokenRepository, UserDTOMapper mapper) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.tokenRepository = tokenRepository;
        this.mapper = mapper;
    }

    public UserDTO execute(LogOutInputData inputData) {
        try{
            UUID token  = inputData.getToken();

            if(!tokenRepository.existsById(token)) {
                throw new Exception("Invalid Token");
            }

            String username = inputData.getUsername();
            User commonUser = userRepository.findByUsername(username);
            UUID userId = commonUser.getUserId();

            userRepository.deleteById(userId);

            return mapper.create(commonUser);

        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }
}
