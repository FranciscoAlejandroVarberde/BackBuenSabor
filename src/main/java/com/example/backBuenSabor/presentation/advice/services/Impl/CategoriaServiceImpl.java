package com.example.backBuenSabor.presentation.advice.services.Impl;

import com.example.backBuenSabor.presentation.advice.services.IArticuloInsumoService;
import com.example.backBuenSabor.presentation.advice.services.IArticuloManufacturadoService;
import com.example.backBuenSabor.presentation.advice.services.ICategoriaService;
import com.example.backBuenSabor.domain.entities.Articulo;
import com.example.backBuenSabor.domain.entities.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl extends BaseServiceImpl<Categoria,Long> implements ICategoriaService {

    @Autowired
    private IArticuloInsumoService articuloInsumoService;
    @Autowired
    private IArticuloManufacturadoService articuloManufacturadoService;

    @Override
    public Categoria asignarSubcategorias(Long id, List<Long> subcategoriasIds) {
        var categoria = findById(id);
        var subcategorias = findAll().stream()
                .filter(subcategoria -> subcategoriasIds.contains(subcategoria.getId()))
                .collect(Collectors.toList());
        subcategorias.forEach(subcategoria -> categoria.getSubCategorias().add(subcategoria));
        return update(categoria);
    }

    @Override
    public Categoria removerSubcategorias(Long id, List<Long> subcategoriasIds) {
        var categoria = findById(id);
        var tempSet = new HashSet<Categoria>();
        categoria.getSubCategorias().forEach(subcategoria -> {
            if(subcategoriasIds.contains(subcategoria.getId())){
                tempSet.add(subcategoria);
            }
        });
        categoria.getSubCategorias().removeAll(tempSet);
        return update(categoria);
    }

    @Override
    public Categoria asignarArticulos(Long id, List<Long> articulosIds) {
        var categoria = findById(id);
        var articulosInsumos = articuloInsumoService.findAll().stream()
                .filter(articuloInsumo -> articulosIds.contains(articuloInsumo.getId()))
                .collect(Collectors.toList());
        articulosInsumos.forEach(articuloInsumo -> categoria.getArticulos().add(articuloInsumo));
        var articulosManufacturados = articuloManufacturadoService.findAll().stream()
                .filter(articuloManufacturado -> articulosIds.contains(articuloManufacturado.getId()))
                .collect(Collectors.toList());
        articulosManufacturados.forEach(articuloManufacturado -> categoria.getArticulos().add(articuloManufacturado));
        return update(categoria);
    }

    @Override
    public Categoria removerArticulos(Long id, List<Long> articulosIds) {
        var categoria = findById(id);
        var tempSet = new HashSet<Articulo>();
        categoria.getArticulos().forEach(articulo -> {
            if(articulosIds.contains(categoria.getId())){
                tempSet.add(articulo);
            }
        });
        categoria.getArticulos().removeAll(tempSet);
        return update(categoria);
    }
}
