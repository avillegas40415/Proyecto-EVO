package com.EVO.gym.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="membresias")
public class Membresia implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_mem")
    private Long idMembresia;
    private String nombre;
    private String descripcion;
    private double precio;
    private boolean activo;
    
    public Membresia() {
    }

    public Membresia(String descripcion, double precio, boolean activo) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.activo = activo;
    }
    
    public Long getIdMembresia() {
        return idMembresia;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public boolean isActivo() {
        return activo;
    }
}
