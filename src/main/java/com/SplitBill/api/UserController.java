package com.SplitBill.api;

import com.SplitBill.data_transmission_object.UserDTO;
import com.SplitBill.data_transmission_object.login_user.LogInUserRequestDTO;
import com.SplitBill.data_transmission_object.login_user.LogInUserResponseDTO;
import com.SplitBill.data_transmission_object.register_user.RegisterUserRequestDTO;
import com.SplitBill.data_transmission_object.register_user.RegisterUserResponseDTO;
import com.SplitBill.domain.User;
import com.SplitBill.service.general_service.user.UserService;
import com.SplitBill.service.login_user.LogInUserServiceInterface;
import com.SplitBill.service.register_user.RegisterUserServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final RegisterUserServiceInterface registerUserService;
    private final LogInUserServiceInterface logInUserService;
    private final UserService userService;

    public UserController(RegisterUserServiceInterface registerUserService, LogInUserServiceInterface logInUserService, UserService userService) {
        this.registerUserService = registerUserService;
        this.logInUserService = logInUserService;
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public RegisterUserResponseDTO registerUser(@RequestBody RegisterUserRequestDTO request) {
        return registerUserService.execute(request);
    }

    @RequestMapping(method = RequestMethod.GET)
    public LogInUserResponseDTO logInUser(@RequestBody LogInUserRequestDTO request) {
        LogInUserResponseDTO result = logInUserService.execute(request);
        return result;
    }

    @RequestMapping(value="/getUsers", method=RequestMethod.GET)
    public List<UserDTO> getUsers(@RequestBody List<UUID> userIds){
        return userService.getUsers(userIds);
    }
}
