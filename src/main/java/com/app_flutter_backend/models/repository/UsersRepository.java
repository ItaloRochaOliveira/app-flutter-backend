package com.app_flutter_backend.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app_flutter_backend.models.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findById(String id);
    Users deleteById(String id);
}
