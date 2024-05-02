package com.example.backBuenSabor.domain.dtos;


import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public abstract class BaseDto {

    private Long id;

    protected boolean estaActivo;

}