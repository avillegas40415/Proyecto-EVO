package com.EVO.gym.service.impl;

import com.EVO.gym.dao.BeneficioDao;
import com.EVO.gym.domain.Beneficio;
import com.EVO.gym.service.BeneficioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BeneficioServiceImp implements BeneficioService{
    @Autowired
    private BeneficioDao beneficioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Beneficio> listarBeneficios() {
        return beneficioDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Beneficio beneficio) {
        beneficioDao.save(beneficio);
    }

    @Override
    @Transactional
    public void eliminar(Beneficio beneficio) {
        beneficioDao.delete(beneficio);
    }

    @Override
    @Transactional(readOnly = true)
    public Beneficio encontrarBeneficio(Beneficio beneficio) {
        return beneficioDao.findById(beneficio.getIdBeneficio()).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Beneficio> listarBeneficiosPorMembresia(Long idMembresia) {
        return beneficioDao.findByMembresiaIdMembresia(idMembresia); 
    }
}
