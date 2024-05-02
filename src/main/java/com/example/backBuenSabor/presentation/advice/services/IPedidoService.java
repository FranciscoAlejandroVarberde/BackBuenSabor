package com.example.backBuenSabor.presentation.advice.services;

import com.example.backBuenSabor.domain.entities.Pedido;

public interface IPedidoService extends IBaseService<Pedido,Long>{
    Pedido create(Pedido entity, Long domicilioId, Long sucursalId);
}
