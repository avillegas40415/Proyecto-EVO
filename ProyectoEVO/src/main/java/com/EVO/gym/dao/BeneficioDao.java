package com.EVO.gym.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EVO.gym.domain.Beneficio;
import java.util.List;

public interface BeneficioDao extends JpaRepository <Beneficio,Long>{
    List<Beneficio> findByMembresiaIdMembresia(Long idMembresia);
}
