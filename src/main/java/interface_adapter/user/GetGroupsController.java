package interface_adapter.user;

import data_transmission_object.GroupDTO;
import data_transmission_object.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import use_case.get_groups.GetGroupsInputBoundary;
import use_case.get_groups.GetGroupsInputData;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/user/getgroups")
public class GetGroupsController {
    private GetGroupsInputBoundary use_case;

    public GetGroupsController(GetGroupsInputBoundary use_case) {
        this.use_case = use_case;
    }

    @GetMapping()
    public GetGroupsResponse execute(@RequestBody GetGroupsRequest request) {
        String username = request.user().username();
        GetGroupsInputData inputData = new GetGroupsInputData(username, request.token());
        List<GroupDTO> result = use_case.execute(inputData);

        return new GetGroupsResponse(result);
    }

    public record GetGroupsRequest(UserDTO user, UUID token) {}

    public record GetGroupsResponse(List<GroupDTO> groups) {}
}
