package com.finsight.user.dto;

import java.util.UUID;

import com.finsight.user.entity.User;
import com.finsight.user.enums.UserRole;

public record UserResponse(
    UUID id,
    String name,
    String email,
    UserRole role
) {
    public static UserResponse from(User user) {
        return new UserResponse(
            user.getId(),
            user.getFirstName() + " " + user.getLastName(),
            user.getEmail(),
            user.getRole()
        );
    }
}
