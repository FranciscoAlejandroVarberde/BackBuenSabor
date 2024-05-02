package com.example.backBuenSabor.presentation.advice.services.Impl;

import com.example.backBuenSabor.presentation.advice.services.ICategoriaService;
import com.example.backBuenSabor.presentation.advice.services.IDomicilioService;
import com.example.backBuenSabor.presentation.advice.services.IPromocionService;
import com.example.backBuenSabor.presentation.advice.services.ISucursalService;
import com.example.backBuenSabor.domain.entities.Categoria;
import com.example.backBuenSabor.domain.entities.Promocion;
import com.example.backBuenSabor.domain.entities.Sucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SucursalServiceImpl extends BaseServiceImpl<Sucursal,Long> implements ISucursalService {
    @Autowired
    IDomicilioService domicilioService;
    @Autowired
    ICategoriaService categoriaService;
    @Autowired
    IPromocionService promocionService;

    @Override
    public Sucursal asignarDomicilio(Long id, Long idDomicilio) {
        var sucursal = findById(id);
        var domicilio = domicilioService.findById(idDomicilio);
        sucursal.setDomicilio(domicilio);
        return update(sucursal);
    }

    @Override
    public Sucursal asignarCategorias(Long id, List<Long> categoriasIds) {
        var sucursal = findById(id);
        var categorias = categoriaService.findAll().stream()
                .filter(categoria -> categoriasIds.contains(categoria.getId()))
                .collect(Collectors.toList());
        categorias.forEach(categoria -> sucursal.getCategorias().add(categoria));
        return update(sucursal);
    }

    @Override
    public Sucursal removerCategorias(Long id, List<Long> categoriasIds) {
        var sucursal = findById(id);
        var tempSet = new HashSet<Categoria>();
        sucursal.getCategorias().forEach(categoria -> {
            if(categoriasIds.contains(categoria.getId())){
                tempSet.add(categoria);
            }
        });
        sucursal.getCategorias().removeAll(tempSet);
        return update(sucursal);
    }

    @Override
    public Sucursal asignarPromociones(Long id, List<Long> promocionesIds) {
        var sucursal = findById(id);
        var promociones = promocionService.findAll().stream()
                .filter(promocion -> promocionesIds.contains(promocion.getId()))
                .collect(Collectors.toList());
        promociones.forEach(promocion -> sucursal.getPromociones().add(promocion));
        return update(sucursal);
    }

    @Override
    public Sucursal removerPromociones(Long id, List<Long> promocionesIds) {
        var sucursal = findById(id);
        var tempSet = new HashSet<Promocion>();
        sucursal.getPromociones().forEach(promocion -> {
            if(promocionesIds.contains(promocion.getId())){
                tempSet.add(promocion);
            }
        });
        sucursal.getPromociones().removeAll(tempSet);
        return update(sucursal);
    }
}
