package com.SplitBill.api;

import com.SplitBill.data_transmission_object.UserDTO;
import com.SplitBill.data_transmission_object.create_group.CreateGroupRequestDTO;
import com.SplitBill.data_transmission_object.create_group.CreateGroupResponseDTO;
import com.SplitBill.data_transmission_object.GroupDTO;
import com.SplitBill.service.create_group.CreateGroupServiceInterface;
import com.SplitBill.service.general_service.user.UserService;
import com.SplitBill.service.get_groups.GetGroupsServiceInterface;
import com.SplitBill.service.get_members.GetMembersServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/group")
public class GroupController {
    private final CreateGroupServiceInterface createGroupService;
    private final GetGroupsServiceInterface getGroupsService;
    private final GetMembersServiceInterface getMembersService;

    public GroupController(CreateGroupServiceInterface createGroupService, GetGroupsServiceInterface getGroupsService, GetMembersServiceInterface getMembersService) {
        this.createGroupService = createGroupService;
        this.getGroupsService = getGroupsService;
        this.getMembersService = getMembersService;
    }


    @PostMapping
    @RequestMapping("/create")
    public CreateGroupResponseDTO createGroup(CreateGroupRequestDTO request){
        return createGroupService.execute(request);
    }

    @RequestMapping(value="/groupId={id}", method = RequestMethod.GET)
    public List<UUID> getMembers(@PathVariable UUID id){
        return getMembersService.execute(id);
    }

    @RequestMapping(value = "/userId={id}", method = RequestMethod.GET)
    public List<GroupDTO> getGroups(@PathVariable String id){
        return getGroupsService.execute(UUID.fromString(id));
    }

}
