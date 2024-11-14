package com.app_flutter_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app_flutter_backend.models.entity.Users;
import com.app_flutter_backend.models.repository.UsersRepository;

@Service
public class UsersService {
    private UsersRepository usersRepository;

    @Autowired
    public void instanceRepo(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public List<Users> getAll(){
        return usersRepository.findAll();
    }

    public Users getById(String id){
        return usersRepository.findById(id);
    }

    public Users create(Users userForCreate){
        return usersRepository.save(userForCreate);
    }

    public Users edit(String id, Users userInfo){
        Users userForUpdate = usersRepository.findById(id);
        userForUpdate.setName(userInfo.getName());
        userForUpdate.setEmail(userInfo.getEmail());
        userForUpdate.setUpdated_at(userInfo.getUpdated_at());
        return usersRepository.save(userForUpdate);
    }

    public Users delete(String id){
        Users userDeleted = usersRepository.deleteById(id);;
    }
}
