package com.example.Libreria.dto;

import com.example.Libreria.entity.Socio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestamoDto {

    private Date fecha;

    private Socio socio;

    private List<DetallePrestamoDto>detallePrestamoDtos;
}
