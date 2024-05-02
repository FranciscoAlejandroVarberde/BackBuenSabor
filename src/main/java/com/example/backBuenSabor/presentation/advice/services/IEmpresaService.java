package com.example.backBuenSabor.presentation.advice.services;

import com.example.backBuenSabor.domain.entities.Empresa;

import java.util.List;

public interface IEmpresaService extends IBaseService<Empresa,Long>{
    Empresa asignarSucursales(Long id, List<Long> sucursalesIds);
    Empresa removerSucursales(Long id, List<Long> sucursalesIds);
}
