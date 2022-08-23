package com.example.Libreria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name= "autor")
@Table(name= "autor")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","referenceList"})
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="dni")
    private String dni;

    @JsonIgnore
    @OneToMany(mappedBy = "autor")
    private List<Libro> libro = new java.util.ArrayList<>();
}
