package com.example.backBuenSabor.presentation.advice.services;

import com.example.backBuenSabor.domain.entities.ArticuloInsumo;

import java.util.List;

public interface IArticuloInsumoService extends IArticuloService<ArticuloInsumo, Long> {
    ArticuloInsumo asignarImagenes(Long id, List<Long> imagenesIds);
    ArticuloInsumo removerImagenes(Long id, List<Long> imagenesIds);
    ArticuloInsumo asignarUnidadMedida(Long id, Long unidadMedidaId);
}
