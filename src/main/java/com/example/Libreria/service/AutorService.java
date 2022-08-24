package com.example.Libreria.service;

import com.example.Libreria.entity.Autor;

import java.util.Optional;

public interface AutorService {

    Optional<Autor> getAutor (Long id);

    Optional<Autor> getAutorPorDni(String dni);

    Autor saveAutor (Autor autor);

    Autor getAutorById(Long id);
}
