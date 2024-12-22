package use_case.logout;

import data_transmission_object.UserDTO;
import entity.CommonUser;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import repository.GroupRepository;
import repository.TokenRepository;
import repository.UserRepository;

import java.util.UUID;

public class LogOutInteractor {
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final TokenRepository tokenRepository;


    public LogOutInteractor(UserRepository userRepository, GroupRepository groupRepository, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.tokenRepository = tokenRepository;
    }

    public UserDTO execute(LogOutInputData inputData) {
        try{
            UUID token  = inputData.getToken();

            if(!tokenRepository.existsById(token)) {
                throw new Exception("Invalid Token");
            }

            String username = inputData.getUsername();
            CommonUser commonUser = userRepository.findByUsername(username);




        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }
}
