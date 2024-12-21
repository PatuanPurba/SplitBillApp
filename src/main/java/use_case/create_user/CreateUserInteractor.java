package use_case.create_user;

import entity.CommonUser;
import entity.CommonUserFactory;
import jakarta.transaction.Transactional;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreateUserInteractor implements CreateUserInputBoundary{
    private final CreateUserDataAccessInterface DataAccess;
    private final CommonUserFactory userFactory;



    public CreateUserInteractor(CreateUserDataAccessInterface dataAccess, CommonUserFactory userFactory) {
        DataAccess = dataAccess;
        this.userFactory = userFactory;
    }

    @Transactional
    public CreateUserOutputData execute(CreateUserInputData request){
        try{
            System.out.println("Username: " + request.getUsername());

            if (DataAccess.existsByUsername(request.getUsername())){
//                CreateUserOutputData response = new CreateUserOutputData();
//                response.setErrorMessage("Username already exists");
//                return response;

                throw new Exception("Username already exists");
            }

            String first_name = request.getFirst_name();
            String last_name = request.getLast_name();
            String password = request.getPassword();
            String username = request.getUsername();

            CommonUser user = userFactory.create(username, password, first_name, last_name);

            CommonUser new_user = DataAccess.save(user);



            if ("".equals(new_user.getUserId())){
                throw new Exception("Error during process");
            }

            else{
                return new CreateUserOutputData(first_name, last_name, username, new_user.getUserId());
            }

        }catch (SQLException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }catch (Exception e){
//            System.out.println(e.getMessage());
//            CreateUserOutputData response = new CreateUserOutputData();
//            response.setErrorMessage(e.getMessage());
//            return response;
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
