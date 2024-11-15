package com.app_flutter_backend.controller;

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
    public IUserServiceReturn getAll(){
        IUserServiceReturn users = userService.getAll();
        System.err.println(users);
        return users;
    }

    @GetMapping("/{id}")
    public IUserServiceReturn getById(@PathVariable String id){
        IUserServiceReturn users = userService.getById(id);
        return users;
    }
    
    @PostMapping
    public IUserServiceReturn create(@RequestBody @Valid Users user){
        IUserServiceReturn users = userService.create(user);
        return users;
    }

    @PutMapping("/{id}")
    public IUserServiceReturn update(@RequestBody @Valid Users user, @PathVariable String id){
        IUserServiceReturn users = userService.edit(id, user);
        return users;
    }

    @DeleteMapping("/{id}")
    public IUserServiceReturn delete(@PathVariable String id){
        IUserServiceReturn users = userService.delete(id);
        return users;
    }
}