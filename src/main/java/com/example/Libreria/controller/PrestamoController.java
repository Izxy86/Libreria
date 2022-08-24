package com.example.Libreria.controller;

import com.example.Libreria.dto.PrestamoDto;
import com.example.Libreria.entity.Prestamo;
import com.example.Libreria.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrestamoController {

    @Autowired
    PrestamoService prestamoService;

    @PostMapping("/prestarLibro")
    public Prestamo prestarLibro(@RequestBody PrestamoDto prestamo){
        return prestamoService.prestarLibros(prestamo);
    }
}
