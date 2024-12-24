package com.SplitBill.service.register_user;

import com.SplitBill.data_transmission_object.register_user.RegisterUserRequestDTO;
import com.SplitBill.data_transmission_object.register_user.RegisterUserResponseDTO;
import com.SplitBill.domain.User;
import com.SplitBill.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;

@Service
public class RegisterUserService implements RegisterUserServiceInterface {
    private final UserRepository userRepository;

    public RegisterUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public RegisterUserResponseDTO execute(RegisterUserRequestDTO request){
        try{
            if (userRepository.existsByUsername(request.username())){
                throw new Exception("Username already exists");
            }
            String first_name = request.firstName();
            String last_name = request.lastName();
            String password = request.password();
            String username = request.username();

            User user = new User(null, username, password, first_name, last_name);
            User new_user = userRepository.save(user);
            return new RegisterUserResponseDTO(new_user.getUserId(), new_user.getUsername(), new_user.getPassword());
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
