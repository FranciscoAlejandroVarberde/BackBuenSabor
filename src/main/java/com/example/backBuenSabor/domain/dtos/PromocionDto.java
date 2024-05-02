package com.example.backBuenSabor.domain.dtos;



import com.example.backBuenSabor.domain.enums.TipoPromocion;
import lombok.*;



import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class PromocionDto extends BaseDto {
    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalTime horaDesde;
    private LocalTime horaHasta;
    private String descripcionDescuento;
    private Double precioPromocional;
    private TipoPromocion tipoPromocion;



    private Set<ArticuloDto> articulos = new HashSet<>();


    private Set<ImagenDto> imagenes = new HashSet<>();


    private Set<SucursalDto> sucursales = new HashSet<>();


    private Set<PromocionDetalleDto> detalles= new HashSet<>();

}
