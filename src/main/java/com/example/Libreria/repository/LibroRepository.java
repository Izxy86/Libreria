package com.example.Libreria.repository;

import com.example.Libreria.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibroRepository  extends JpaRepository<Libro, Long> {
    Optional<Libro> getLibroByNombre(String nombre);

    List<Libro> getLibroByAutor(String nombre);

    List<Libro> getLibroByGenero(String nombre);
}
