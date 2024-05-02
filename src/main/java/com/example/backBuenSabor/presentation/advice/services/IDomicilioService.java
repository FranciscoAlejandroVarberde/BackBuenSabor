package com.example.backBuenSabor.presentation.advice.services;

import com.example.backBuenSabor.domain.entities.Domicilio;

public interface IDomicilioService extends IBaseService<Domicilio,Long>{
    Domicilio asignarLocalidad(Long id, Long idLocalidad);
}
