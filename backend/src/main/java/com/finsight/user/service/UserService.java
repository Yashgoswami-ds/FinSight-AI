package com.finsight.user.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finsight.user.dto.UserResponse;
import com.finsight.user.entity.User;
import com.finsight.user.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public UserResponse getById(UUID id) {
        User user = userRepository.findById(id)
            .orElseThrow(UserNotFoundException::new);
        return UserResponse.from(user);
    }

    public static class UserNotFoundException extends RuntimeException {
    }
}
