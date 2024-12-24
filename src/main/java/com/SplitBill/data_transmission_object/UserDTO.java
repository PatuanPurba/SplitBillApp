package com.SplitBill.data_transmission_object;

import java.util.UUID;

public record UserDTO(
        String username,
        String firstName,
        String lastName,
        UUID userId
) {}
