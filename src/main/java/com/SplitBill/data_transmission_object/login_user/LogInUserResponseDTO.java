package com.SplitBill.data_transmission_object.login_user;

import com.SplitBill.data_transmission_object.UserDTO;

public record LogInUserResponseDTO(UserDTO user, String accessToken) {
}
