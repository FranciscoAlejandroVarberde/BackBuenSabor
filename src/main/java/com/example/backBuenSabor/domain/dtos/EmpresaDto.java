package com.example.backBuenSabor.domain.dtos;




import lombok.*;

import java.util.HashSet;
import java.util.Set;




@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class EmpresaDto extends BaseDto {
    private String nombre;
    private String razonSocial;
    private Integer cuil;


    private Set<SucursalDto> listaSucursal= new HashSet<>();

}
