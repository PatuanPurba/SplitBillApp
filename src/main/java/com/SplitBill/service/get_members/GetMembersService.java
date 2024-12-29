package com.SplitBill.service.get_members;

import com.SplitBill.data_transmission_object.UserDTO;
import com.SplitBill.domain.Group;
import com.SplitBill.domain.User;
import com.SplitBill.domain.UsersGroups;
import com.SplitBill.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GetMembersService implements GetMembersServiceInterface {
    @Autowired
    private GroupRepository groupRepository;



    @Override
    public List<UUID> execute(UUID groupId) {
        Group group = groupRepository.findById(groupId).orElse(null);

        if (group == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group does not exist");
        }

        List<UUID> result = new ArrayList<>();
        for (UsersGroups usersGroups: group.getRelationship()){
            result.add(usersGroups.getUser().getUserId());
        }

        return result;
    }
}
