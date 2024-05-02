package com.example.backBuenSabor.domain.dtos;


import com.example.backBuenSabor.domain.enums.Estado;
import com.example.backBuenSabor.domain.enums.FormaPago;
import com.example.backBuenSabor.domain.enums.TipoEnvio;
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

public class PedidoDto extends BaseDto {
    private LocalTime horaEstimadaFinalizacion;
    private Double total;
    private Double totalCosto;
    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private LocalDate fechaPedido;

    private DomicilioDto domicilio;

    private SucursalDto sucursal;

    private FacturaDto factura;

    private Set<DetallePedidoDto> detallePedidos = new HashSet<>();

}
