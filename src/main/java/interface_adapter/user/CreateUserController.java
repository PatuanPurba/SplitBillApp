package interface_adapter.user;

import data_transmission_object.UserDTO;
import interface_adapter.BaseController;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import use_case.create_user.CreateUserInputBoundary;
import use_case.create_user.CreateUserInputData;
import use_case.create_user.CreateUserOutputData;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/create")
public class CreateUserController{

    private final CreateUserInputBoundary use_case;

    public CreateUserController(CreateUserInputBoundary createUserInputBoundary) {
        this.use_case = createUserInputBoundary;
    }

    @PostMapping
    public ResponseEntity<UserDTO> executeImpl(@RequestBody SignUpRequest request) {
        String firstName = request.firstName();
        String lastName = request.lastName();
        String username = request.username();
        String password = request.password();

        CreateUserInputData inputData = new CreateUserInputData(firstName, lastName, username, password);
        use_case.execute(inputData);

        UserDTO response = new UserDTO(username, firstName, lastName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public record SignUpRequest(String firstName, String lastName, String username, String password) {}
}
