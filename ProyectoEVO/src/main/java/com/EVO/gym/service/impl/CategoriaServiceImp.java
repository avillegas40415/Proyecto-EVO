package com.EVO.gym.service.impl;

import com.EVO.gym.dao.CategoriaDao;
import com.EVO.gym.dao.ProductoDao;
import com.EVO.gym.domain.Categoria;
import com.EVO.gym.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImp implements CategoriaService {
    
    @Autowired
    private CategoriaDao categoriaDao;
    
    @Autowired
    private ProductoDao productoDao; // Inyecta el ProductoDao

    @Override
    @Transactional(readOnly=true)
    public List<Categoria> getCategorias(boolean activos) {
        var lista=categoriaDao.findAll();
        if (activos) {
           lista.removeIf((Categoria e) -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    /*@Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }*/
    
    @Override
    @Transactional
    public void save(Categoria categoria) {
        // Obtener la categoría existente de la base de datos
        Categoria categoriaExistente = categoriaDao.findById(categoria.getIdCategoria()).orElse(null);

        if (categoriaExistente != null) {
            // Actualizar el nombre de la categoría existente
            categoriaExistente.setDescripcion(categoria.getDescripcion());
            // ... actualizar otras propiedades si es necesario ...

            // Guardar la categoría actualizada
            categoriaDao.save(categoriaExistente);
        } else {
            // Si la categoría no existe, guardar una nueva
            categoriaDao.save(categoria);
        }
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
    
    @Override
    public boolean tieneProductosAsociados(Categoria categoria) {
        // Busca productos que tengan la categoría especificada
        return productoDao.existsByCategoria(categoria); 
    }
    
    @Override
    public Categoria getCategoria(Long id) { // Cambiar el tipo de argumento a Long
        return categoriaDao.findById(id).orElse(null); 
    }
    

}

