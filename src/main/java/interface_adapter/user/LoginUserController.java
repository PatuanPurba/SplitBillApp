package interface_adapter.user;

import data_transmission_object.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import use_case.login_user.LoginUserInputBoundary;
import use_case.login_user.LoginUserInputData;
import use_case.login_user.LoginUserOutputData;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/login")
public class LoginUserController {
    private final LoginUserInputBoundary use_case;

    public LoginUserController(LoginUserInputBoundary useCase) {
        use_case = useCase;
    }

    @GetMapping
    public ResponseEntity<SignInResponse> executeImpl(@RequestBody SignInRequest request) {
        String username = request.username();
        String password = request.password();


        LoginUserInputData inputData = new LoginUserInputData(username, password);
        LoginUserOutputData responseInteractor = use_case.execute(inputData);

        String firstName = responseInteractor.getUser().getFirstName();
        String lastName = responseInteractor.getUser().getLastName();
        UUID token = responseInteractor.getToken();

        UserDTO user = new UserDTO(username, firstName, lastName);
        SignInResponse response = new SignInResponse(user, token);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public record SignInRequest(String username, String password) {}

    public record SignInResponse(UserDTO user, UUID token){}
}
