package com.example.backBuenSabor.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class ArticuloDto implements Serializable {
    protected Long id;
    protected boolean estaActivo;
    protected String denominacion;
    protected Double precioVenta;
    private Set<ImagenDto> imagenes = new HashSet<>();
    private UnidadMedidaDto unidadMedida;

}