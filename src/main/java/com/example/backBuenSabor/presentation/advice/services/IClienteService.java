package com.example.backBuenSabor.presentation.advice.services;

import com.example.backBuenSabor.domain.entities.Cliente;

import java.util.List;

public interface IClienteService extends IPersonaService<Cliente,Long>{
    Cliente asignarUsuario(Long id, Long idUsuario);
    Cliente asignarImagen(Long id, Long idImagen);
    Cliente asignarPedidos(Long id, List<Long> pedidosIds);
    Cliente removerPedidos(Long id, List<Long> pedidosIds);
    Cliente asignarDomicilios(Long id, List<Long> domiciliosIds);
    Cliente removerDomicilios(Long id, List<Long> domiciliosIds);
}
