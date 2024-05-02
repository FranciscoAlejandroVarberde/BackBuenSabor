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
public class Provincia extends Base {
    private String nombre;

    @ManyToOne
    private Pais pais;

}
