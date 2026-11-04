package com.finsight.auth.service;

import java.util.Locale;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finsight.auth.dto.RegisterRequest;
import com.finsight.auth.dto.RegisterResponse;
import com.finsight.user.entity.User;
import com.finsight.user.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public RegisterResponse register(RegisterRequest request) {
        String email = request.email().trim().toLowerCase(Locale.ROOT);
        if (userRepository.existsByEmail(email)) {
            throw new DuplicateEmailException();
        }

        String[] name = splitName(request.name());
        User user = new User(
            email,
            passwordEncoder.encode(request.password()),
            name[0],
            name[1]
        );

        try {
            return RegisterResponse.from(userRepository.save(user));
        } catch (DataIntegrityViolationException exception) {
            throw new DuplicateEmailException();
        }
    }

    private String[] splitName(String value) {
        String normalized = value.trim().replaceAll("\\s+", " ");
        int separator = normalized.indexOf(' ');
        if (separator < 1 || separator == normalized.length() - 1) {
            throw new InvalidNameException();
        }
        return new String[] {
            normalized.substring(0, separator),
            normalized.substring(separator + 1)
        };
    }

    public static class DuplicateEmailException extends RuntimeException {
    }

    public static class InvalidNameException extends RuntimeException {
    }
}
