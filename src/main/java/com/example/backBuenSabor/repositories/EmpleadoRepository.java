package com.example.backBuenSabor.repositories;

import com.example.backBuenSabor.domain.entities.Empleado;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends PersonaRepository<Empleado,Long> {
}
