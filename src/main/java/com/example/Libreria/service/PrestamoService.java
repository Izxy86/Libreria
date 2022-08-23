package com.example.Libreria.service;

import com.example.Libreria.dto.PrestamoDto;
import com.example.Libreria.entity.DetallePrestamo;
import com.example.Libreria.entity.Prestamo;

public interface PrestamoService {

    Prestamo prestarLibro(PrestamoDto prestamoDto);

    DetallePrestamo crearDetallePrestamo(DetallePrestamoDto detallePrestamo);
}
