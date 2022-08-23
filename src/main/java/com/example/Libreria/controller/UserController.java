package com.example.Libreria.controller;

import com.example.Libreria.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<?>getUsers(){
        List<String> users = userService.getUsuarios();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUsers(@PathVariable(value = "id")String id){
        String usuario = userService.getUsuario(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> postUser (@RequestBody String user){
        String userGuardado = userService.guardarUsuario(user);
        return ResponseEntity.created(null).body(userGuardado);
    }
}
