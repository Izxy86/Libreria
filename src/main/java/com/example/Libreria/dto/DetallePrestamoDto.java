package com.example.Libreria.dto;

import com.example.Libreria.entity.Libro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetallePrestamoDto {

    private Libro libro;
}
