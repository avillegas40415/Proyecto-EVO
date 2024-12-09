package com.EVO.gym.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


@Data​
@Entity​
@Table(name="producto")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id​
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Long idProducto;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String rutaImagen;
    private boolean activo;

    @ManyToOne​
    @JoinColumn(name="id_categoria")
    Categoria categoria;

    public Producto() {
    }
    
    public Producto(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
    
    public Long getIdProducto() {
        return idProducto;
    }
    
    public void setIdProducto(Long idProducto){
        this.idProducto = idProducto;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
     public String getDetalle() {
        return detalle;
    }
     
    public void setDetalle(String detalle){
        this.detalle = detalle;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    public int getExistencias() {
        return existencias;
    }
    
    public void setExistencias(int existencias){
        this.existencias = existencias;
    }
    
    public boolean isActivo() {
        return activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen){
        this.rutaImagen = rutaImagen;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;

    }
}