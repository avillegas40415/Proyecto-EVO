package com.EVO.gym.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EVO.gym.domain.Factura;


public interface FacturaDao extends JpaRepository <Factura,Long>{
    
}
