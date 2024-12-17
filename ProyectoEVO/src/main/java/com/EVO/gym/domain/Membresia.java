package com.EVO.gym.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
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
    private boolean destacar;
    private boolean activo;
    
    
    //@OneToMany(mappedBy = "membresia", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //private List<Beneficio> beneficios;

    @OneToMany(mappedBy = "membresia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Beneficio> beneficios = new ArrayList<>();
    
    /*
    @OneToMany
    @JoinColumn(name="id_mem")
    List<Beneficio> beneficios;*/
    
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
    
    public boolean getDestacar(){
        return destacar;
    }
    
    public void setDestacar(boolean destacar){
        this.destacar = destacar;
    }
    
    public boolean isActivo() {
        return activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    public List<Beneficio> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(List<Beneficio> beneficios) {
        this.beneficios = beneficios;
    }
    
    // Método para agregar un beneficio a la lista
    public void agregarBeneficio(Beneficio beneficio) {
        beneficios.add(beneficio);
        beneficio.setMembresia(this);
    }

    // Método para eliminar un beneficio de la lista
    public void eliminarBeneficio(Beneficio beneficio) {
        beneficios.remove(beneficio);
        beneficio.setMembresia(null);
    }
}
    
