package com.example.backBuenSabor.domain.entities;

import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Audited
public class UnidadMedida extends Base{

    private String denominacion;


}
