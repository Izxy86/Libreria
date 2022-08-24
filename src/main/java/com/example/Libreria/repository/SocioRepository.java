package com.example.Libreria.repository;

import com.example.Libreria.entity.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SocioRepository extends JpaRepository<Socio, Long>{
    @Query("SELECT s FROM socio WHERE s.dni = :dni")
    Optional<Socio> findByDni(String dni);
}
