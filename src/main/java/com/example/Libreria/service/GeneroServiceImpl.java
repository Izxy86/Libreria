package com.example.Libreria.service;

import com.example.Libreria.entity.Genero;
import com.example.Libreria.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GeneroServiceImpl implements GeneroService{

    @Autowired
    GeneroRepository generoRepository;

    public Optional<Genero> getGenero(Long id){return generoRepository.findById(id);}

    public Optional<Genero> getGeneroPorNombre(String nombre){return generoRepository.findByNombre(nombre);}

    public Genero saveGenero(Genero genero){return generoRepository.save(genero);}

}
