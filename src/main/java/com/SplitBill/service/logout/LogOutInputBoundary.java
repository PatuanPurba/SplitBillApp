package com.SplitBill.service.logout;

import com.SplitBill.data_transmission_object.UserDTO;

public interface LogOutInputBoundary {
    UserDTO execute(LogOutInputData inputData);
}
