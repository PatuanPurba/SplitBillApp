package interface_adapter.group;

import data_transmission_object.GroupDTO;
import data_transmission_object.UserDTO;
import entity.CommonGroup;
import interface_adapter.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import use_case.create_group.CreateGroupInputBoundary;
import use_case.create_group.CreateGroupInputData;
import use_case.create_group.CreateGroupOutputData;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/group/create")
public class CreateGroupController {
    private final CreateGroupInputBoundary use_case;


    public CreateGroupController(CreateGroupInputBoundary useCase) {
        use_case = useCase;
    }

    @PostMapping
    public ResponseEntity<GroupDTO> executeImpl(@RequestBody CreateGroupRequest request) {
        System.out.println("User : " + request.user());

        String username = request.user().username();
        String groupName = request.groupName();
        UUID token = request.token();

        CreateGroupInputData inputData = new CreateGroupInputData(username, groupName, token);
        CreateGroupOutputData responseInteractor =  use_case.execute(inputData);

        GroupDTO response = new GroupDTO(groupName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public record CreateGroupRequest(UserDTO user, String groupName, UUID token) {}
}
