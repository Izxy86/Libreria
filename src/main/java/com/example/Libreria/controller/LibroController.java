package com.example.Libreria.controller;

import com.example.Libreria.entity.Libro;
import com.example.Libreria.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibroController {

    @Autowired
    LibroService libroService;

    @GetMapping("/libro/{id}")
    public Libro getLibro(@PathVariable(name = "id")Long id){return libroService.getLibroById(id);}

    @GetMapping("/saveLibro")
    public Libro saveLibro(@RequestBody Libro libro){return libroService.saveLibro(libro);}



}
