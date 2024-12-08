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
    
    // Agregar el método setIdMembresia
    public void setIdMembresia(Long idMembresia) {
        this.idMembresia = idMembresia;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    public boolean isActivo() {
        return activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
