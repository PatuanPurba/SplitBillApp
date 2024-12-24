package com.SplitBill.service.login_user;

import com.SplitBill.data_transmission_object.login_user.LogInUserRequestDTO;
import com.SplitBill.data_transmission_object.login_user.LogInUserResponseDTO;

public interface LogInUserServiceInterface {
    LogInUserResponseDTO execute(LogInUserRequestDTO request);
}
