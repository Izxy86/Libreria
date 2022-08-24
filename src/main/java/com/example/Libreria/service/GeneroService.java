package com.example.Libreria.service;

import com.example.Libreria.entity.Genero;

import java.util.Optional;

public interface GeneroService {

    Optional<Genero> getGenero(Long id);

    Optional<Genero> getGeneroPorNombre(String nombre);

    Genero saveGenero(Genero genero);

}
