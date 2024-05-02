package com.example.backBuenSabor.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Localidad extends Base{
    private String nombre;



    @ManyToOne
    private Provincia provincia;

}
