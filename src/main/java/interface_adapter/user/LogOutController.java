package interface_adapter.user;

import data_transmission_object.UserDTO;
import entity.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import use_case.logout.LogOutInputBoundary;
import use_case.logout.LogOutInputData;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/user/logout")
public class LogOutController {
    private final LogOutInputBoundary use_case;

    public LogOutController(LogOutInputBoundary useCase) {
        use_case = useCase;
    }

    @DeleteMapping
    UserDTO execute(@RequestBody LogOutRequest request){
        String username = request.user().getUsername();
        UUID token = request.token();

        LogOutInputData inputData = new LogOutInputData(username, token);
        return use_case.execute(inputData);
    }

    record LogOutRequest(User user, UUID token){}

}
