package com.example.backBuenSabor.presentation.advice.services.Impl;

import com.example.backBuenSabor.presentation.advice.services.IPaisService;
import com.example.backBuenSabor.presentation.advice.services.IProvinciaService;
import com.example.backBuenSabor.domain.entities.Provincia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaServiceImpl extends BaseServiceImpl<Provincia,Long> implements IProvinciaService {
    @Autowired
    private IPaisService paisService;

    @Override
    public Provincia asignarPais(Long id, Long idPais) {
        var provincia = findById(id);
        var pais = paisService.findById(idPais);
        provincia.setPais(pais);
        return update(provincia);
    }
}
