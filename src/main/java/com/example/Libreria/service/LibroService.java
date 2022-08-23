package com.example.Libreria.service;

import com.example.Libreria.entity.Libro;

import java.util.List;

public interface LibroService {

    Libro getLibroById(Long id);

    List<Libro> getLibrosByAutor(String nombre);

    List<Libro> getLibrosByGenero(String nombre);

    Libro saveLibro(Libro libro);

    Libro getLibroByNombre(String nombre);

    void restarStockListaLibro(List<Libro> libroList);
}
