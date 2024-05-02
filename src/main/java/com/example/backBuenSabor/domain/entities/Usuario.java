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
public class Usuario  extends Base{
    private String auth0Id;
    private String userName;


}
