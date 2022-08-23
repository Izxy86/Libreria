package com.example.Libreria.service;

import com.example.Libreria.dto.DetallePrestamoDto;
import com.example.Libreria.dto.PrestamoDto;
import com.example.Libreria.entity.DetallePrestamo;
import com.example.Libreria.entity.Libro;
import com.example.Libreria.entity.Prestamo;
import com.example.Libreria.entity.Socio;
import com.example.Libreria.repository.PrestamoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@Slf4j
public class PrestamoServiceImpl  implements PrestamoService{

    @Autowired
    PrestamoRepository prestamoRepository;

    @Autowired
    LibroService libroService;

    @Autowired
    SocioService socioService;


    public Prestamo prestarLibros(PrestamoDto prestamoDto){
        Socio socio = socioService.obtenerSocioPorDni(prestamoDto.getSocio());

        List<Libro> libroList = new ArrayList<>();

        for(DetallePrestamoDto detallePrestamoDto : prestamoDto.getDetallePrestamoDtos()){
            Libro libro = libroService.getLibroByNombre(detallePrestamoDto.getLibro().getNombre());
            libroList.add(libro);
        }
        Prestamo prestamo = new Prestamo();
        prestamo.setSocio(socio);
        prestamo.setFecha(prestamoDto.getFecha());
        prestamo.setDetallePrestamo(new HashSet<>());

        for (DetallePrestamoDto detallePrestamoDto : prestamoDto.getDetallePrestamoDtos()){
            prestamo.agregarDetalle(crearDetallePrestamo(detallePrestamoDto));
        }

        libroService.restarStockListaLibro(libroList);

        Prestamo prestamo1 = prestamoRepository.save(prestamo);
        log.info("Informacion de prestamo warning{}",prestamo1);

        return prestamo;
    }

    DetallePrestamo crearDetallePrestamo(DetallePrestamoDto detallePrestamo){
        DetallePrestamo detallePrestamoAGuardar = new DetallePrestamo();
        detallePrestamoAGuardar.setNombreLibro(detallePrestamo.getLibro().getNombre());
        return detallePrestamoAGuardar;
    }
}
