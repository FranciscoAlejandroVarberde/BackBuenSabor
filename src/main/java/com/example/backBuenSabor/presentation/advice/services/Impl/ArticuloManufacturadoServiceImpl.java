package com.example.backBuenSabor.presentation.advice.services.Impl;

import com.example.backBuenSabor.presentation.advice.services.IArticuloManufacturadoService;
import com.example.backBuenSabor.presentation.advice.services.IImagenService;
import com.example.backBuenSabor.presentation.advice.services.IUnidadMedidaService;
import com.example.backBuenSabor.domain.entities.ArticuloManufacturado;
import com.example.backBuenSabor.domain.entities.Imagen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticuloManufacturadoServiceImpl extends ArticuloServiceImpl<ArticuloManufacturado,Long> implements IArticuloManufacturadoService {
    @Autowired
    private IImagenService imagenService;
    @Autowired
    private IUnidadMedidaService unidadMedidaService;

    @Override
    public ArticuloManufacturado asignarImagenes(Long id, List<Long> imagenesIds) {
        var articulo = findById(id);
        var imagenes = imagenService.findAll().stream()
                .filter(imagen -> imagenesIds.contains(imagen.getId()))
                .collect(Collectors.toList());
        imagenes.forEach(imagen -> articulo.getImagenes().add(imagen));
        return update(articulo);
    }

    @Override
    public ArticuloManufacturado removerImagenes(Long id, List<Long> imagenesIds) {
        var articulo = findById(id);
        var tempSet = new HashSet<Imagen>();
        articulo.getImagenes().forEach(imagen -> {
            if(imagenesIds.contains(imagen.getId())){
                tempSet.add(imagen);
            }
        });
        articulo.getImagenes().removeAll(tempSet);
        return update(articulo);
    }

    @Override
    public ArticuloManufacturado asignarUnidadMedida(Long id, Long unidadMedidaId) {
        var articulo = findById(id);
        var unidadMedida = unidadMedidaService.findById(unidadMedidaId);
        articulo.setUnidadMedida(unidadMedida);
        return update(articulo);
    }
}
