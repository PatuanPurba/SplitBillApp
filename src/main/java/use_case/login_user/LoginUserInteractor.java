package use_case.login_user;

import entity.User;
import entity.CommonUserFactory;
import entity.Token;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LoginUserInteractor implements LoginUserInputBoundary{

    private final CommonUserFactory userFactory;
    private final LoginUserDataAccessInterface dataAccessUser;
    private final LoginTokenDataAccessInterface dataAccessToken;


    public LoginUserInteractor(CommonUserFactory userFactory, LoginUserDataAccessInterface dataAccessUser, LoginTokenDataAccessInterface dataAccessToken) {
        this.userFactory = userFactory;
        this.dataAccessUser = dataAccessUser;
        this.dataAccessToken = dataAccessToken;
    }


    @Override
    public LoginUserOutputData execute(LoginUserInputData request) {
        try{
            String username = request.getUsername();
            String password = request.getPassword();

            if (! dataAccessUser.existsByUsername(username)) {
                throw new Exception("Username not Exists");
            }

            User tempUser = dataAccessUser.findByUsername(username);

            if (!tempUser.getPassword().equals(password)) {
                throw new Exception("Wrong Password");
            }else {
                Token token = dataAccessToken.save(new Token());
                return new LoginUserOutputData(tempUser, token.getId());
            }

        }catch (Exception e) {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }
}
