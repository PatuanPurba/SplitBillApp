package com.SplitBill.service.login_user;

import com.SplitBill.data_transmission_object.login_user.LogInUserRequestDTO;
import com.SplitBill.data_transmission_object.login_user.LogInUserResponseDTO;
import com.SplitBill.data_transmission_object.mapper.UserDTOMapper;
import com.SplitBill.domain.User;
import com.SplitBill.domain.Token;
import com.SplitBill.repository.TokenRepository;
import com.SplitBill.repository.UserRepository;
import com.SplitBill.service.jwt.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LogInUserService implements LogInUserServiceInterface {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final UserDTOMapper mapper = new UserDTOMapper();
    private final JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);


    public LogInUserService(UserRepository userRepository, TokenRepository tokenRepository, JWTService jwtService) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.jwtService = jwtService;
    }




    @Override
    public LogInUserResponseDTO execute(LogInUserRequestDTO request) {
        try{


            String username = request.username();
            String password = request.password();
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            if (authentication.isAuthenticated()) {
                User tempUser = userRepository.findByUsername(username);
                return new LogInUserResponseDTO(mapper.create(tempUser), jwtService.generateToken(username));
            }

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }catch (Exception e) {
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
}
