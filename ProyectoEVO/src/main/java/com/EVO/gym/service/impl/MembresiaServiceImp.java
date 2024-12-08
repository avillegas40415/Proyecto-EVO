package com.EVO.gym.service.impl;

import com.EVO.gym.dao.MembresiaDao;
import com.EVO.gym.domain.Membresia;
import com.EVO.gym.service.MembresiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MembresiaServiceImp implements MembresiaService{
    
    @Autowired
    private MembresiaDao membresiaDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Membresia> getMembresias(boolean activos) {
        var lista=membresiaDao.findAll();
        if (activos) {
           lista.removeIf((Membresia e) -> !e.isActivo());
        }
        return lista;
    }
    
    //@Override
    @Transactional(readOnly = true)
    public Membresia getMembresia(Long idMembresia) {
        return membresiaDao.findById(idMembresia).orElse(null);
    }
    /*public Membresia getMembresia(Membresia membresia) {
        return membresiaDao.findById(membresia.getIdMembresia()).orElse(null);
    }*/

    @Override
    @Transactional
    public void save(Membresia membresia) {
        membresiaDao.save(membresia);
    }

    @Override
    @Transactional
    public void delete(Membresia membresia) {
        membresiaDao.delete(membresia);
    }

    @Override
    public Membresia getMembresia(Membresia membresia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
