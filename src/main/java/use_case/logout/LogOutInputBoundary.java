package use_case.logout;

import data_transmission_object.UserDTO;
import use_case.login_user.LoginUserInputData;

public interface LogOutInputBoundary {
    UserDTO execute(LogOutInputData inputData);
}
