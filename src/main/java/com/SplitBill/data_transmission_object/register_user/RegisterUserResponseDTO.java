package com.SplitBill.data_transmission_object.register_user;

import java.util.UUID;

public record RegisterUserResponseDTO(UUID userId, String username, String password) {
}
