package com.EVO.gym.service.impl;

import com.EVO.gym.dao.NoticiaDao;
import com.EVO.gym.domain.Noticia;
import com.EVO.gym.service.NoticiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class NoticiaServiceImp implements NoticiaService{
    
    @Autowired
    private NoticiaDao noticiaDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Noticia> getNoticias(boolean activos) {
        var lista=noticiaDao.findAll();
        if (activos) {
           lista.removeIf((Noticia e) -> !e.isActivo());
        }
        return lista;
    }
    
    
    /*public Noticia getNoticia(Long idNoticia) {
        return noticiaDao.findById(idNoticia).orElse(null);
    }*/
    @Override
    @Transactional(readOnly = true)
    public Noticia getNoticia(Noticia noticia) {
        return noticiaDao.findById(noticia.getIdNoticia()).orElse(null);
    }
    @Override
    @Transactional
    public void save(Noticia noticia) {
        noticiaDao.save(noticia);
    }
    @Override
    @Transactional
    public void delete(Noticia noticia) {
        noticiaDao.delete(noticia);
    }
    
    /*@Override
    public Noticia getNoticia(Noticia noticia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
    
    @Override
    public Noticia getNoticiaById(Long id) {
        return noticiaDao.findById(id).orElse(null);
    }
}
