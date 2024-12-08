package com.EVO.gym.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EVO.gym.domain.Noticia;

public interface NoticiaDao extends JpaRepository <Noticia,Long> {
    
}
