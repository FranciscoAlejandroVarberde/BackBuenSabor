package com.example.backBuenSabor.repositories;

import com.example.backBuenSabor.domain.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface PersonaRepository <E extends Persona, ID extends Serializable> extends JpaRepository<E, ID> {
}
