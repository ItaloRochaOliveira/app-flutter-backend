package com.app_flutter_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app_flutter_backend.models.entity.Users;
import com.app_flutter_backend.models.repository.UsersRepository;

@Service
public class UsersService {
    public List<Users> getAll(){
        return (List<Users>) UsersRepository.findAll();
    }
}
