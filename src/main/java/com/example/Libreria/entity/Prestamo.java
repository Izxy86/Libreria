package com.example.Libreria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="prestamo")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Prestamo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="prestamo_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name= "socio_id")
    private Socio socio;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @OneToMany(mappedBy = "prestamo",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<DetallePrestamo> detallePrestamo;

    public DetallePrestamo agregarDetalle(DetallePrestamo detallePrestamo){
       getDetallePrestamo().add(detallePrestamo);
       detallePrestamo.setPrestamo(this);
       return detallePrestamo;
    }
    public DetallePrestamo removerDetalle (DetallePrestamo detallePrestamo){
        getDetallePrestamo().remove(detallePrestamo);
        detallePrestamo.setPrestamo(null);
        return detallePrestamo;
    }

}
