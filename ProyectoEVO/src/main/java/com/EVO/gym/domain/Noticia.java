package com.EVO.gym.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name="noticias")
public class Noticia implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_noticia")
    private Long idNoticia;
    private String titulo;
    private String texto;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date posteo;
    private boolean activo;

    public Noticia() {
    }

    public Noticia(Long idNoticia, String titulo, String texto, Date posteo, boolean activo) {
        this.idNoticia = idNoticia;
        this.titulo = titulo;
        this.texto = texto;
        this.posteo = posteo;
        this.activo = activo;
    }
    
    public Long getIdNoticia() {
        return idNoticia;
    }
    
    public void setIdNoticia(Long idNoticia) {
        this.idNoticia = idNoticia;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getTexto(){
        return texto;
    }
    
    public void setTexto(String texto){
        this.texto = texto;
    }
    
    public Date getPosteo(){
        return posteo;
    }
    
    public void setPosteo(Date posteo){
        this.posteo = posteo;
    }
    
    public boolean isActivo() {
        return activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
