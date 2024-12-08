package com.EVO.gym.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EVO.gym.domain.Membresia;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface MembresiaDao extends JpaRepository <Membresia,Long> {
    @Query("SELECT m FROM Membresia m LEFT JOIN FETCH m.beneficios")
    List<Membresia> findAllWithBeneficios();
}
