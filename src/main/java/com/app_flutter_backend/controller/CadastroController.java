package com.app_flutter_backend.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class CadastroController{
    private List<String> lista = new ArrayList<String>();

    private void setList(String item){
        lista.add(item);
    }

    @GetMapping
    public List<String> teste(){
        setList("Item1");
        setList("item2");
        System.out.println("Retorno?");
        return lista;
    }
}