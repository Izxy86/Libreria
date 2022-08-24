package com.example.Libreria.repository;

import com.example.Libreria.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeneroRepository extends JpaRepository<Genero, Long> {


    Optional<Genero> findByNombre(String nombre);

}
