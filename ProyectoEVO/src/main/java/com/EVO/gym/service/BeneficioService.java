package com.EVO.gym.service;

import com.EVO.gym.domain.Beneficio;
import java.util.List;

public interface BeneficioService {
    public List<Beneficio> listarBeneficios();
    public void guardar(Beneficio beneficio);
    public void eliminar(Beneficio beneficio);
    public Beneficio encontrarBeneficio(Beneficio beneficio);
    public List<Beneficio> listarBeneficiosPorMembresia(Long idMembresia);
}
