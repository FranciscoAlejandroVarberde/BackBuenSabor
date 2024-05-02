    package com.example.backBuenSabor.domain.entities;

    import com.example.backBuenSabor.domain.enums.Rol;
    import jakarta.persistence.*;
    import lombok.*;
    import org.hibernate.envers.Audited;

    import java.util.HashSet;
    import java.util.Set;

    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    @Builder
    @Audited
    public class Empleado extends Persona{


        private Rol tipoEmpleado;

        @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true)
        @Builder.Default
        private Set<Pedido> pedidos= new HashSet<>();

        @ManyToOne
        @JoinColumn(name = "sucursal_id")
        private Sucursal sucursal;
    }
