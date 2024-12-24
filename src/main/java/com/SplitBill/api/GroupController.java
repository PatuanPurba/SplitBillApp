package com.SplitBill.api;

import com.SplitBill.data_transmission_object.create_group.CreateGroupRequestDTO;
import com.SplitBill.data_transmission_object.create_group.CreateGroupResponseDTO;
import com.SplitBill.data_transmission_object.GroupDTO;
import com.SplitBill.service.create_group.CreateGroupServiceInterface;
import com.SplitBill.service.get_groups.GetGroupsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/group")
public class GroupController {
    @Autowired
    private CreateGroupServiceInterface createGroupService;

    @Autowired
    private GetGroupsServiceInterface getGroupsService;

    @PostMapping
    @RequestMapping("/create")
    public CreateGroupResponseDTO createGroup(CreateGroupRequestDTO request){
        return createGroupService.execute(request);
    }

    @GetMapping
    @RequestMapping("/userId={id}")
    public List<GroupDTO> getGroups(@PathVariable String id){
        return getGroupsService.execute(UUID.fromString(id));
    }

}
