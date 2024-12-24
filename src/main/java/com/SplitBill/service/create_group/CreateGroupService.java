package com.SplitBill.service.create_group;

import com.SplitBill.data_transmission_object.create_group.CreateGroupRequestDTO;
import com.SplitBill.data_transmission_object.create_group.CreateGroupResponseDTO;
import com.SplitBill.domain.Group;
import com.SplitBill.domain.User;
import com.SplitBill.domain.UsersGroups;
import com.SplitBill.domain.UsersGroupsId;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.SplitBill.repository.GroupRepository;
import com.SplitBill.repository.TokenRepository;
import com.SplitBill.repository.UserRepository;

import java.util.UUID;

@Service
public class CreateGroupService implements CreateGroupServiceInterface {

    private final TokenRepository tokenRepository;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    public CreateGroupService(TokenRepository tokenRepository, UserRepository userRepository, GroupRepository groupRepository) {
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }


    @Override
    public CreateGroupResponseDTO execute(CreateGroupRequestDTO inputData) {
        try{
            UUID userId = inputData.userId();
            Group group = new Group(inputData.groupName());

            Group new_group = groupRepository.save(group);
            User new_user = userRepository.findById(userId).orElse(null);
            if (new_user == null) {throw new Exception("User Id Not Exist on Database");}

            // Add user and group into UsersGroups
            UsersGroups usersGroups = new UsersGroups(new UsersGroupsId(userId, new_group.getGroupId()));
            usersGroups.setUser(new_user);
            usersGroups.setGroup(new_group);

            new_group.getRelationship().add(usersGroups);
            groupRepository.save(new_group);

            return new CreateGroupResponseDTO(new_group.getGroupName(), new_group.getGroupId());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
