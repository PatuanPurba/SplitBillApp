package use_case.create_user;

public interface CreateUserInputBoundary {
    CreateUserOutputData execute(CreateUserInputData inputData);
}
