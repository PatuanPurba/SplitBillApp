package com.SplitBill.api;

import com.SplitBill.data_transmission_object.login_user.LogInUserRequestDTO;
import com.SplitBill.data_transmission_object.login_user.LogInUserResponseDTO;
import com.SplitBill.data_transmission_object.register_user.RegisterUserRequestDTO;
import com.SplitBill.data_transmission_object.register_user.RegisterUserResponseDTO;
import com.SplitBill.service.login_user.LogInUserServiceInterface;
import com.SplitBill.service.register_user.RegisterUserServiceInterface;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final RegisterUserServiceInterface registerUserService;
    private final LogInUserServiceInterface logInUserService;

    public UserController(RegisterUserServiceInterface registerUserService, LogInUserServiceInterface logInUserService) {
        this.registerUserService = registerUserService;
        this.logInUserService = logInUserService;
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


}
