package com.app_flutter_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app_flutter_backend.interfaces.service.IUserServiceReturn;
import com.app_flutter_backend.models.entity.Users;
import com.app_flutter_backend.models.repository.UsersRepository;

@Service
public class UsersService {
    private UsersRepository usersRepository;

    @Autowired
    public void instanceRepo(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public IUserServiceReturn getAll(){
        return new IUserServiceReturn(
            200,
            "Consulta feita com sucesso",
            usersRepository.findAll()
        );
    }

    public IUserServiceReturn getById(String id){
        System.out.println("Aqui");
        System.out.println(usersRepository.findById(id));
        return new IUserServiceReturn(
            200, 
        "Consulta feita com sucesso",
            usersRepository.findById(id).orElse(null)
            );
    }

    public IUserServiceReturn create(Users userForCreate){
        return new IUserServiceReturn(
            200, 
        "Usuário criado com sucesso",
                usersRepository.save(userForCreate)
            );
    }

    public IUserServiceReturn edit(String id, Users userInfo){
        Users userForUpdate = usersRepository.findById(id)
    .orElse(null);
        userForUpdate.setName(userInfo.getName());
        userForUpdate.setEmail(userInfo.getEmail());
        userForUpdate.setUpdated_at(userInfo.getUpdated_at());
        return new IUserServiceReturn(
            200, 
        "Usuário editado com sucesso",
                usersRepository.save(userForUpdate)
            );
    }

    public IUserServiceReturn delete(String id){
        Users user = usersRepository.findById(id).orElse(null);
        if(user.getId() == null) return new IUserServiceReturn(
            200, 
        "Usuário não existe mais no banco de dados",
                usersRepository.findById(id).orElse(null)
            );
        usersRepository.deleteById(id);
        return new IUserServiceReturn(
            200, 
        "Usuário excluido com sucesso",
                usersRepository.findById(id).orElse(null)
            );
    }
}
