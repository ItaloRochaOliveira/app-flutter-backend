package com.app_flutter_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app_flutter_backend.interfaces.service.IUserServiceReturn;
import com.app_flutter_backend.models.entity.Users;
import com.app_flutter_backend.service.UsersService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class CadastroController{
    private UsersService userService;

    @Autowired
    public void instanceRepo(UsersService userService){
        this.userService = userService;
    }

    @GetMapping
    public IUserServiceReturn<List<Users>> getAll(){
        IUserServiceReturn<List<Users>> users = userService.getAll();
        System.err.println(users);
        return users;
    }

    @GetMapping("/{id}")
    public IUserServiceReturn<Users> getById(@PathVariable String id){
        IUserServiceReturn<Users> users = userService.getById(id);
        return users;
    }
    
    @PostMapping
    public IUserServiceReturn<Users> create(@RequestBody @Valid Users user){
        IUserServiceReturn<Users> users = userService.create(user);
        return users;
    }

    @PutMapping("/{id}")
    public IUserServiceReturn<Users> update(@RequestBody @Valid Users user, @PathVariable String id){
        IUserServiceReturn<Users> users = userService.edit(id, user);
        return users;
    }

    @DeleteMapping("/{id}")
    public IUserServiceReturn<Users> delete(@PathVariable String id){
        IUserServiceReturn<Users> users = userService.delete(id);
        return users;
    }
}