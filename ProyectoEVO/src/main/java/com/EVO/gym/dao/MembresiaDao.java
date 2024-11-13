package com.EVO.gym.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EVO.gym.domain.Membresia;

public interface MembresiaDao extends JpaRepository <Membresia,Long> {
    
}
