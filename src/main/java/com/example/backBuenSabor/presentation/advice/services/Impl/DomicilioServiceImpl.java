package com.example.backBuenSabor.presentation.advice.services.Impl;

import com.example.backBuenSabor.presentation.advice.services.IDomicilioService;
import com.example.backBuenSabor.presentation.advice.services.ILocalidadService;
import com.example.backBuenSabor.domain.entities.Domicilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio,Long> implements IDomicilioService {
    @Autowired
    private ILocalidadService localidadService;

    @Override
    public Domicilio asignarLocalidad(Long id, Long idLocalidad) {
        var domicilio = findById(id);
        var localidad = localidadService.findById(idLocalidad);
        domicilio.setLocalidad(localidad);
        return update(domicilio);
    }
}
