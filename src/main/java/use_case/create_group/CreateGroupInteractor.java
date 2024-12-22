package use_case.create_group;

import entity.CommonGroup;
import entity.CommonUser;
import entity.UsersGroups;
import entity.UsersGroupsId;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import repository.GroupRepository;
import repository.TokenRepository;
import repository.UserRepository;

import java.util.UUID;

@Service
public class CreateGroupInteractor implements CreateGroupInputBoundary{

    private final TokenRepository tokenRepository;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    public CreateGroupInteractor(TokenRepository tokenRepository, UserRepository userRepository, GroupRepository groupRepository) {
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }


    @Override
    public CreateGroupOutputData execute(CreateGroupInputData inputData) {
        try{
            UUID token = inputData.getToken();
            if (!tokenRepository.existsById(token)) {
                throw new Exception("Invalid Token");
            }

            String username = inputData.getUsername();
            CommonGroup group = new CommonGroup(inputData.getGroupName());

            CommonGroup new_group = groupRepository.save(group);
            CommonUser new_user = userRepository.findByUsername(username);
            UUID userId = new_user.getUserId();

            // Add user and group into UsersGroups
            UsersGroups usersGroups = new UsersGroups(new UsersGroupsId(userId, new_group.getGroupId()));
            usersGroups.setUser(new_user);
            usersGroups.setGroup(new_group);

            new_group.getRelationship().add(usersGroups);
            groupRepository.save(new_group);
            return new CreateGroupOutputData(new_group.getGroupName());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
