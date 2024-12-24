package com.SplitBill.service.register_user;

import com.SplitBill.data_transmission_object.register_user.RegisterUserRequestDTO;
import com.SplitBill.data_transmission_object.register_user.RegisterUserResponseDTO;

public interface RegisterUserServiceInterface {
    RegisterUserResponseDTO execute(RegisterUserRequestDTO inputData);
}
