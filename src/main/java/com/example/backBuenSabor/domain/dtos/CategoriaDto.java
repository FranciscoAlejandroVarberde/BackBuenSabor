package com.example.backBuenSabor.domain.dtos;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CategoriaDto extends BaseDto {

    private String denominacion;

    private Set<SucursalDto> sucursales = new HashSet<>();

    private Set<ArticuloDto> articulos = new HashSet<>();

    private Set<CategoriaDto> subCategorias = new HashSet<>();
}
