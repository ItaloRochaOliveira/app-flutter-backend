package com.app_flutter_backend.service;

import java.util.List;
import java.util.stream.Collectors;

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
        List<Users> users = usersRepository.findAll();
        if(users.size() != 0) users.stream().map(
            user -> {
                user.setTelefone(setMask(user.getTelefone()));
                return true;
            }
        )
        .collect(Collectors.toList());
        return new IUserServiceReturn(
            200,
            "Consulta feita com sucesso",
            users
        );
    }

    public IUserServiceReturn getById(String id){
        Users user = usersRepository.findById(id).orElse(null);
        if(user != null) user.setTelefone(setMask(user.getTelefone()));

        return new IUserServiceReturn(
            200, 
        "Consulta feita com sucesso",
            user
            );
    }

    public IUserServiceReturn create(Users userForCreate){
        String telefoneWithoutMask = userForCreate.getTelefone().replaceAll("[\\s+\\-()]", "");
        userForCreate.setTelefone(telefoneWithoutMask);
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
        String telefoneWithoutMask = userInfo.getTelefone().replaceAll("[\\s+\\-()]", "");
        userForUpdate.setTelefone(telefoneWithoutMask);
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

    private String setMask(String telefoneWithoutMask){
        return telefoneWithoutMask.replaceAll("(\\d{2})(\\d{2})(\\d{5})(\\d{4})", "(+$1) $2 $3-$4");
    }
}
