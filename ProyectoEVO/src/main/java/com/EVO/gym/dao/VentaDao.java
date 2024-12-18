package com.EVO.gym.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EVO.gym.domain.Venta;

public interface VentaDao extends JpaRepository <Venta,Long>{
    
}
