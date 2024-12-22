package use_case.logout;

import data_transmission_object.UserDTO;
import data_transmission_object.UserDTOMapper;
import entity.CommonUser;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import repository.GroupRepository;
import repository.TokenRepository;
import repository.UserRepository;

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
            CommonUser commonUser = userRepository.findByUsername(username);
            UUID userId = commonUser.getUserId();

            userRepository.deleteById(userId);

            return mapper.create(commonUser);

        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }
}
