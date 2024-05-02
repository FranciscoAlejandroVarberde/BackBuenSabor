package com.example.backBuenSabor.domain.dtos;


import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class DomicilioDto extends BaseDto {
    private String calle;
    private int numero;
    private int cp;

    private LocalidadDto localidad;


}
