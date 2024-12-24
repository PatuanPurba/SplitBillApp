package com.SplitBill.service.login_user;

import com.SplitBill.data_transmission_object.login_user.LogInUserRequestDTO;
import com.SplitBill.data_transmission_object.login_user.LogInUserResponseDTO;
import com.SplitBill.data_transmission_object.mapper.UserDTOMapper;
import com.SplitBill.domain.User;
import com.SplitBill.domain.Token;
import com.SplitBill.repository.TokenRepository;
import com.SplitBill.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LogInUserService implements LogInUserServiceInterface {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final UserDTOMapper mapper = new UserDTOMapper();


    public LogInUserService(UserRepository userRepository, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }


    @Override
    public LogInUserResponseDTO execute(LogInUserRequestDTO request) {
        try{
            String username = request.username();
            String password = request.password();

            if (! userRepository.existsByUsername(username)) {
                throw new Exception("Username not Exists");
            }

            User tempUser = userRepository.findByUsername(username);

            if (!tempUser.getPassword().equals(password)) {
                throw new Exception("Wrong Password");
            }else {
                Token token = tokenRepository.save(new Token());
                return new LogInUserResponseDTO(mapper.create(tempUser));
            }

        }catch (Exception e) {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }
}
