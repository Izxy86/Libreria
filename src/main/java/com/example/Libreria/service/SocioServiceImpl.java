package com.example.Libreria.service;

import com.example.Libreria.entity.Socio;
import com.example.Libreria.repository.SocioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class SocioServiceImpl implements SocioServiceImpl {

    @Autowired
    SocioRepository socioRepository;

    public Socio obtenerSocioPorDni(Socio socio){
        Optional<Socio> buscarSocio= socioRepository.findByDni(socio.getDni());
        if (buscarSocio.isPresent()){
            log.info ("Ya existe socio");
            return buscarSocio.get();
        }
        else{
            log.info("Se guardó un socio nuevo");
            return socioRepository.save(socio);
        }
    }
}
