package use_case.get_groups;

import data_transmission_object.GroupDTO;
import entity.User;
import entity.UsersGroups;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import repository.GroupRepository;
import repository.TokenRepository;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GetGroupsInteractor implements GetGroupsInputBoundary{
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;

    public GetGroupsInteractor(GroupRepository groupRepository, UserRepository userRepository, TokenRepository tokenRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }

    public List<GroupDTO> execute(GetGroupsInputData inputData) {
        try{
            UUID token = inputData.getToken();
            if (!tokenRepository.existsById(token)) {
                throw new Exception("Invalid Token");
            }

            String username = inputData.getUsername();
            List<GroupDTO> result = new ArrayList<>();

            User user = userRepository.findByUsername(username);
            for (UsersGroups relation: user.getRelationship()){
               result.add(new GroupDTO(relation.getGroup().getGroupName()));
            }
            return result;

        }catch (Exception e){
            System.out.println("Error : " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
}
