package com.SplitBill.service.add_member;

import com.SplitBill.data_transmission_object.AddMemberDTO;
import com.SplitBill.data_transmission_object.GroupDTO;
import com.SplitBill.domain.Group;
import com.SplitBill.domain.User;
import com.SplitBill.domain.UsersGroups;
import com.SplitBill.repository.GroupRepository;
import com.SplitBill.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class AddMemberService implements AddMemberServiceInterface{
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    public AddMemberService(UserRepository userRepository, GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public GroupDTO execute(AddMemberDTO inputData) {
        UUID userId = inputData.userId();
        UUID groupId = inputData.groupId();

        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not Found");
        }

        Group group = groupRepository.findById(groupId).orElse(null);
        if (group == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group not Found");
        }

        UsersGroups usersGroups = new UsersGroups();
        usersGroups.setUser(user);
        usersGroups.setGroup(group);

        group.getRelationship().add(usersGroups);
        groupRepository.save(group);

        return new GroupDTO(group.getGroupName(), groupId);
    }
}
