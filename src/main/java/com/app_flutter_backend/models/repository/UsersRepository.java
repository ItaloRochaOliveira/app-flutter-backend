package com.app_flutter_backend.models.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import com.app_flutter_backend.models.entity.Users;

public interface UsersRepository extends JpaRepository<Users, String> {
    @NonNull Optional<Users> findById(@NonNull String id);
    void deleteById(@NonNull String id);
}
