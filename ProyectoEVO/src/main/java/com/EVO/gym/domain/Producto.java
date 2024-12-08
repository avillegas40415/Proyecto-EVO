package com.EVO.gym.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="productos")
public class Producto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pro")
    private Long idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private boolean activo;
    
    public Producto() {
    }

    public Producto(String descripcion, double precio, boolean activo) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.activo = activo;
    }
    
    public Long getIdProducto() {
        return idProducto;
    }
    
    // Agregar el método setIdProducto
    
    public void setIdProducto(Long idMembresia) {
        this.idProducto = idProducto;
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
