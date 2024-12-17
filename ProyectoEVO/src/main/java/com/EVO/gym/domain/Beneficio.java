package com.EVO.gym.domain;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="beneficios")
public class Beneficio implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_beneficio")
    private Long idBeneficio;

    @ManyToOne
    @JoinColumn(name = "id_mem")
    private Membresia membresia;

    private String descripcion;

    public Beneficio() {
    }

    public Beneficio(Long idBeneficio, Membresia membresia, String descripcion) {
        this.idBeneficio = idBeneficio;
        this.membresia = membresia;
        this.descripcion = descripcion;
    }
    
    public Long getIdBeneficio() {
        return idBeneficio;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }
}
