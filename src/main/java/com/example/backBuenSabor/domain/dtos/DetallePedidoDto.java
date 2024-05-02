package com.example.backBuenSabor.domain.dtos;


import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class DetallePedidoDto extends BaseDto {
    private Integer cantidad;
    private Double subTotal;

    private ArticuloDto articulo;

}
