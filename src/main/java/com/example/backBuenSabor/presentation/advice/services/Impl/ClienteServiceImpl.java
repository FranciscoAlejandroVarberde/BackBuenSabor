package com.example.backBuenSabor.presentation.advice.services.Impl;

import com.example.backBuenSabor.presentation.advice.services.*;
import com.example.backBuenSabor.domain.entities.Cliente;
import com.example.backBuenSabor.domain.entities.Domicilio;
import com.example.backBuenSabor.domain.entities.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl extends PersonaServiceImpl<Cliente,Long> implements IClienteService {

    @Autowired
    private IDomicilioService domicilioService;
    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private IImagenService imagenService;
    @Autowired
    private IPedidoService pedidoService;


    @Override
    public Cliente asignarUsuario(Long id, Long idUsuario) {
        var cliente = findById(id);
        var usuario = usuarioService.findById(id);
        cliente.setUsuario(usuario);
        return update(cliente);
    }

    @Override
    public Cliente asignarImagen(Long id, Long idImagen) {
        var cliente = findById(id);
        var imagen = imagenService.findById(idImagen);
        cliente.setImagen(imagen);
        return update(cliente);
    }

    @Override
    public Cliente asignarPedidos(Long id, List<Long> pedidosIds) {
        var cliente = findById(id);
        var pedidos = pedidoService.findAll().stream()
                .filter(pedido -> pedidosIds.contains(pedido.getId()))
                .collect(Collectors.toList());
        pedidos.forEach(pedido -> cliente.getPedidos().add(pedido));
        return update(cliente);
    }

    @Override
    public Cliente removerPedidos(Long id, List<Long> pedidosIds) {
        var cliente = findById(id);
        var tempSet = new HashSet<Pedido>();
        cliente.getPedidos().forEach(pedido -> {
            if(pedidosIds.contains(pedido.getId())){
                tempSet.add(pedido);
            }
        });
        cliente.getPedidos().removeAll(tempSet);
        return update(cliente);
    }

    @Override
    public Cliente asignarDomicilios(Long id, List<Long> domiciliosIds) {
        var cliente = findById(id);
        var domicilios = domicilioService.findAll().stream()
                .filter(domicilio -> domiciliosIds.contains(domicilio.getId()))
                .collect(Collectors.toList());
        domicilios.forEach(domicilio -> cliente.getDomicilios().add(domicilio));
        return update(cliente);
    }

    @Override
    public Cliente removerDomicilios(Long id, List<Long> domiciliosIds) {
        var cliente = findById(id);
        var tempSet = new HashSet<Domicilio>();
        cliente.getDomicilios().forEach(domicilio -> {
            if(domiciliosIds.contains(domicilio.getId())){
                tempSet.add(domicilio);
            }
        });
        cliente.getDomicilios().removeAll(tempSet);
        return update(cliente);
    }
}
