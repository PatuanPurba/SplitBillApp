package com.SplitBill.service.get_groups;

import com.SplitBill.data_transmission_object.GroupDTO;
import com.SplitBill.domain.User;
import com.SplitBill.domain.UsersGroups;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.SplitBill.repository.GroupRepository;
import com.SplitBill.repository.TokenRepository;
import com.SplitBill.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GetGroupsService implements GetGroupsServiceInterface {
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;

    public GetGroupsService(GroupRepository groupRepository, UserRepository userRepository, TokenRepository tokenRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }

    public List<GroupDTO> execute(UUID userId) {
        try{

            List<GroupDTO> result = new ArrayList<>();

            User user = userRepository.findById(userId).get();
            for (UsersGroups relation: user.getRelationship()){
               result.add(new GroupDTO(relation.getGroup().getGroupName(), relation.getGroup().getGroupId()));
            }
            return result;

        }catch (Exception e){
            System.out.println("Error : " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
}
