package com.EVO.gym.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EVO.gym.domain.Producto;

public interface ProductoDao extends JpaRepository <Producto,Long> {
    
}
