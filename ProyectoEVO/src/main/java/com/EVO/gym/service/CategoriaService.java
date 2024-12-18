package com.EVO.gym.service;

import com.EVO.gym.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    //Se obtiene un listado de categorias en un List
    public List<Categoria> getCategorias(boolean activos);
    
    // Se obtiene un Categoria, a partir del id de un categoria
    public Categoria getCategoria(Categoria categoria);
    
    public Categoria getCategoria(Long id);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Categoria categoria);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Categoria categoria);
    
    //Se busca productos en la categoria
    public boolean tieneProductosAsociados(Categoria categoria);
    

}
