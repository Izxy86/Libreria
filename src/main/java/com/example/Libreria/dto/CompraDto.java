package com.example.Libreria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraDto {

    ClienteDto clienteDto;

    List<ProductoDto> productoDtoList;
}
