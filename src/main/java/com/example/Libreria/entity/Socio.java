package com.example.Libreria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "socio")
@Table(name = "socio")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column (name = "nombre")
    private String nombre;

    @Column(name = "dni")
    private String dni;
}
