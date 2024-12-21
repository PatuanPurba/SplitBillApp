package use_case.login_user;

public interface LoginUserInputBoundary {
    LoginUserOutputData execute(LoginUserInputData request);
}
