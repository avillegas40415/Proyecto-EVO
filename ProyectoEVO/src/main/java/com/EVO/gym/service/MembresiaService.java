package com.EVO.gym.service;

import com.EVO.gym.domain.Membresia;
import java.util.List;

public interface MembresiaService {
    
    //Se obtiene un listado de Membresias en un List
    public List<Membresia> getMembresias(boolean activos);
    
    // Se obtiene un Membresia, a partir del id de un categoria
    public Membresia getMembresia(Membresia membresia);
    
    // Se inserta una nueva Membresia si el id de la Membresia esta vacío
    // Se actualiza una Membresia si el id de la Membresia NO esta vacío
    public void save(Membresia membresia);
    
    // Se elimina la Membresia que tiene el id pasado por parámetro
    public void delete(Membresia membresia);
    
}
