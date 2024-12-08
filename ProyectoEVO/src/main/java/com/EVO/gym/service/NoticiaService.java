package com.EVO.gym.service;

import com.EVO.gym.domain.Noticia;
import java.util.List;

public interface NoticiaService {
    
    //Se obtiene un listado de Noticias en un List
    public List<Noticia> getNoticias(boolean activos);
    
    // Se obtiene una Noticia, a partir del id de una Noticia
    public Noticia getNoticia(Noticia noticia);
    
    // Se inserta una nueva Noticia si el id de la Noticia esta vacío
    // Se actualiza una Noticia si el id de la Noticia NO esta vacío
    public void save(Noticia noticia);
    
    // Se elimina la Membresia que tiene el id pasado por parámetro
    public void delete(Noticia noticia);
    
}
