package com.EVO.gym.service.impl;

import com.EVO.gym.dao.ProductoDao;
import com.EVO.gym.domain.Membresia;
import com.EVO.gym.domain.Producto;
import com.EVO.gym.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImp implements ProductoService{
    
    @Autowired
    private ProductoDao productoDao;
    
    
    @Transactional(readOnly=true)
    @Override
    public List<Producto> getProductos(boolean activos) {
        var lista=productoDao.findAll();
        if (activos) {
           lista.removeIf((Producto e) -> !e.isActivo());
        }
        return lista;
    }
    
    //@Override
    @Transactional(readOnly = true)
    public Producto getProducto(Long idProducto) {
        return productoDao.findById(idProducto).orElse(null);
    }
    /*public Membresia getMembresia(Membresia membresia) {
        return membresiaDao.findById(membresia.getIdMembresia()).orElse(null);
    }*/

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

    @Override
    public Producto getProducto(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
