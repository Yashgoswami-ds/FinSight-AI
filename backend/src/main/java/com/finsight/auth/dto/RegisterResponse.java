package com.finsight.auth.dto;

import java.util.UUID;

import com.finsight.user.entity.User;
import com.finsight.user.enums.UserRole;

public record RegisterResponse(
    UUID id,
    String name,
    String email,
    UserRole role
) {
    public static RegisterResponse from(User user) {
        return new RegisterResponse(
            user.getId(),
            user.getFirstName() + " " + user.getLastName(),
            user.getEmail(),
            user.getRole()
        );
    }
}
