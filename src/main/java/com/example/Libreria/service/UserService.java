package com.example.Libreria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRestApi userRestApi;

    public List<String> getUsuarios(){
        return userRestApi.getUsuarios();
    }

    public String getUsuario(String id){
        return userRestApi.getUsuariosId(id);
    }

    public String guardarUsuario(String user){
        return userRestApi.guardarUsuario(user);
    }
}
