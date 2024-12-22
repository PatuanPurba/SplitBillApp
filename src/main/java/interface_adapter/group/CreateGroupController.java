package interface_adapter.group;

import data_transmission_object.CreateGroupRequestDTO;
import data_transmission_object.CreateGroupResponseDTO;
import entity.CommonGroup;
import interface_adapter.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import use_case.create_group.CreateGroupInputBoundary;
import use_case.create_group.CreateGroupInputData;
import use_case.create_group.CreateGroupOutputData;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/group/create")
public class CreateGroupController extends BaseController<CreateGroupRequestDTO, CreateGroupResponseDTO> {
    private final CreateGroupInputBoundary use_case;


    public CreateGroupController(CreateGroupInputBoundary useCase) {
        use_case = useCase;
    }

    @PostMapping
    @Override
    public ResponseEntity<CreateGroupResponseDTO> executeImpl(CreateGroupRequestDTO request) {
        UUID userId = request.getUserId();
        String groupName = request.getGroupName();
        UUID token = request.getToken();
        CreateGroupInputData inputData = new CreateGroupInputData(userId, groupName, token);

        CreateGroupOutputData responseInteractor =  use_case.execute(inputData);

        CreateGroupResponseDTO response = new CreateGroupResponseDTO("Success", responseInteractor.getGroupId());
        return new ResponseEntity<CreateGroupResponseDTO>(response, HttpStatus.OK);
    }
}
