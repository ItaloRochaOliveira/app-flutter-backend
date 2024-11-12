package com.app_flutter_backend.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class CadastroController{

    @GetMapping
    public String teste(){
        System.out.println("Retorno?");
        return "Hello Spring Boot";
    }
}