package interface_adapter.user;

import data_transmission_object.UserRequestDTO;
import data_transmission_object.UserResponseDTO;
import interface_adapter.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import use_case.login_user.LoginUserInputBoundary;
import use_case.login_user.LoginUserInputData;
import use_case.login_user.LoginUserOutputData;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/login")
public class LoginUserController extends BaseController<UserRequestDTO, UserResponseDTO> {
    private final LoginUserInputBoundary use_case;

    public LoginUserController(LoginUserInputBoundary useCase) {
        use_case = useCase;
    }


    @GetMapping
    @Override
    public ResponseEntity<UserResponseDTO> executeImpl(UserRequestDTO request) {
        String username = request.getUsername();
        String password = request.getPassword();

        LoginUserInputData inputData = new LoginUserInputData(username, password);
        LoginUserOutputData responseInteractor = use_case.execute(inputData);

        UUID id = responseInteractor.getUser().getUserId();
        String first_name = responseInteractor.getUser().getFirstName();
        String last_name = responseInteractor.getUser().getLastName();

        UserResponseDTO response = new UserResponseDTO(id, username, first_name, last_name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
