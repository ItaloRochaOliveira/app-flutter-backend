package com.app_flutter_backend.models.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app_flutter_backend.models.entity.Users;

public interface UsersRepository extends JpaRepository<Users, String> {
    Optional<Users> findById(String id);
    void deleteById(String id);
}
