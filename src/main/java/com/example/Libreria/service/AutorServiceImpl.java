package com.example.Libreria.service;

import com.example.Libreria.entity.Autor;
import com.example.Libreria.exception.DbException;
import com.example.Libreria.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class AutorServiceImpl implements AutorService{

    @Autowired
    AutorRepository autorRepository;

    public Optional<Autor> getAutor (Long id){
        return autorRepository.findById(id);
    }

    public Optional<Autor> getAutorPorDni(String dni){ return autorRepository.findByDni(dni);}

    public Autor saveAutor (Autor autor){ return autorRepository.save(autor);}

    public Autor getAutorById(Long id){
        Optional<Autor> autor= autorRepository.findById(id);
        if(autor.isPresent()){
            return autor.get();
        }
        else{
            throw new DbException("No se encuentra el autor con el id "+id);
        }
    }
}
