package com.example.backBuenSabor.presentation.advice.services;

import com.example.backBuenSabor.domain.entities.Localidad;

public interface ILocalidadService extends IBaseService<Localidad,Long>{
    Localidad asignarProvincia(Long id, Long idProvincia);
}
