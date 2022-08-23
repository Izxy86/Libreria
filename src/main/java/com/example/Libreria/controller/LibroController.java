package com.example.Libreria.controller;

import com.example.Libreria.entity.Libro;
import com.example.Libreria.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibroController {

    @Autowired
    LibroService libroService;

    @GetMapping("/libro/{id}")
    public Libro getLibro(@PathVariable(name = "id")Long id){return libroService.getLibroById(id);}

    @GetMapping("/saveLibro")
    public Libro saveLibro(@RequestBody Libro libro){return libroService.saveLibro(libro);}

    @GetMapping("/libroAutor/{nombre}")
    public List<Libro> getListByAutor(@PathVariable(name = "nombre")String nombre){
        return libroService.getLibrosByAutor(nombre);
    }

    @GetMapping("/libroGenero/{nombre}")
    public List<Libro> getListByGenero(@PathVariable(name = "nombre") String nombre) {
        return libroService.getLibrosByGenero(nombre);
    }

    @PostMapping("/probarProductoDto")
    public CompraDto getListByGenero(@RequestBody CompraDto compraDto) throws Exception {
        if (compraDto.getProductoDtoList().isEmpty()){
            throw new Exception("Enviaste la lista de productos vacía");
        }
        return compraDto;
    }

}
