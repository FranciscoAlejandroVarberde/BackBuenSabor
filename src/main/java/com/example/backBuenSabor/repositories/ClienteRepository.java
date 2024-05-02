package com.example.backBuenSabor.repositories;

import com.example.backBuenSabor.domain.entities.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends PersonaRepository<Cliente,Long> {
}
