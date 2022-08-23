package com.example.Libreria.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserRestApi {
    RestTemplate restTemplate = new RestTemplate();

    public List<String> getUsuarios(){
        String url = "https://jsonplaceholder.typicode.com/users";
        return restTemplate.getForObject(url,List.class);
    }

    public String getUsuariosId(String id){
        String url = "https://jsonplaceholder.typicode.com/users"+id;
        return restTemplate.getForObject(url, String.class);
    }

    public String guardarUsuario(String user){
        final String url = "https://jsonplaceholder.typicode.com/users";
        return restTemplate.postForObject(url,user,String.class);
    }
}
