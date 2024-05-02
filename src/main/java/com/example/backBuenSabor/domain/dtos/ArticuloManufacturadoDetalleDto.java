package com.example.backBuenSabor.domain.dtos;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ArticuloManufacturadoDetalleDto extends BaseDto {
    private Integer cantidad;


    private ArticuloInsumoDto articuloInsumo;
}
