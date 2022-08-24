package com.example.Libreria.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detalle_prestamo")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DetallePrestamo implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prestamo_id")
    @JsonBackReference
    private Prestamo prestamo;

    public void setNombreLibro(String nombre) {
    }
}
