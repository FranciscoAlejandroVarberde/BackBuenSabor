package com.example.backBuenSabor.repositories;

import com.example.backBuenSabor.domain.entities.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario,Long> {
}
