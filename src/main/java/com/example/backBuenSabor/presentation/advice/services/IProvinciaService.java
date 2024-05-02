package com.example.backBuenSabor.presentation.advice.services;

import com.example.backBuenSabor.domain.entities.Provincia;

public interface IProvinciaService extends IBaseService<Provincia,Long> {
    Provincia asignarPais(Long id, Long idPais);
}
