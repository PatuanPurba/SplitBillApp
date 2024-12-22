package interface_adapter.user;

import data_transmission_object.UserRequestDTO;
import data_transmission_object.UserResponseDTO;
import interface_adapter.BaseController;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import use_case.create_user.CreateUserInputBoundary;
import use_case.create_user.CreateUserInputData;
import use_case.create_user.CreateUserOutputData;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/create")
public class CreateUserController extends BaseController<UserRequestDTO, UserResponseDTO> {

    private final CreateUserInputBoundary use_case;

    public CreateUserController(CreateUserInputBoundary createUserInputBoundary) {
        this.use_case = createUserInputBoundary;
    }

    @PostMapping
    @Override
    public ResponseEntity<UserResponseDTO> executeImpl(UserRequestDTO request) {
        CreateUserInputData inputData = new CreateUserInputData(request.getFirstName(), request.getLastName(), request.getUsername(), request.getPassword());
        CreateUserOutputData responseInteractor = use_case.execute(inputData);

        UUID id = responseInteractor.getUser_id();
        String first_name = responseInteractor.getFirst_name();
        String last_name = responseInteractor.getLast_name();
        String username = responseInteractor.getUsername();

        UserResponseDTO response = new UserResponseDTO(id, username, first_name, last_name, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
