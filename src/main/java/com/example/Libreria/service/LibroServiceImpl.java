package com.example.Libreria.service;

import com.example.Libreria.entity.Autor;
import com.example.Libreria.entity.Genero;
import com.example.Libreria.entity.Libro;
import com.example.Libreria.repository.LibroRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class LibroServiceImpl implements LibroService{

    @Autowired
    LibroRepository libroRepository;

    @Autowired
    GeneroService generoService;

    @Autowired
    AutorService autorService;

    public Libro getLibroById(Long id){
        log.info("Estamos por buscar un  libro por id {}, saludos a {}", id,"coder");
        Optional<Libro> libro = libroRepository.findById(id);
        if(libro.isPresent()){
            log.info("El libro está presente, y su nombre es {}",libro.get().getNombre());
            return libro.get();
        }else{
            log.error("En términos de libro, no hay");
            throw new DbException ("No se encontró libro con el id"+id);
        }
    }

    public List<Libro> getLibrosByAutor(String nombre){return libroRepository.getLibroByAutor(nombre);}
    public List<Libro> getLibrosByGenero(String nombre){return libroRepository.getLibroByGenero(nombre);}

    public Libro saveLibro (Libro libro){
        Optional<Autor> autor = autorService.getAutorPorDni(libro.getAutor().getDni());
        Optional<Genero> genero = generoService.getGeneroPorNombre(libro.getGenero().getNombre());
        if(autor.isPresent()){
            log.info("Ya existe autor");
        }else{
            log.info("Creando autor");
            autor = Optional.ofNullable(autorService.saveAutor(libro.getAutor()));
        }
        if(genero.isPresent()){
            log.info("Ya existe genero");
        }else{
            log.info("Creando género");
            genero = Optional.ofNullable(generoService.saveGenero(libro.getGenero()));
        }
        libro.setAutor(autor.get());
        libro.setGenero(genero.get());
        return libroRepository.save(libro);
    }

    public Libro getLibroByNombre(String nombre){
        return libroRepository.getLibroByNombre(nombre).orElseThrow(()-> new DbException("No existe el libro "+ nombre));
    }

    public void restarStockListaLibro(List<Libro> libroList){
        for (Libro libro : libroList) {
            if(libro.getStock() == 0){
                throw new DbException("No hay más libros en Stock de: "+libro.getNombre());
            }
            else {
                libro.setStock(libro.getStock()-1);
            }


        }
        libroRepository.saveAll(libroList);
    }

}
