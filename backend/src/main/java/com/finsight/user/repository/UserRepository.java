package com.finsight.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finsight.user.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByEmail(String email);
}
