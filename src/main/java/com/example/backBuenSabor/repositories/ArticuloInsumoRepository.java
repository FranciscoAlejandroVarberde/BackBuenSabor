package com.example.backBuenSabor.repositories;

import com.example.backBuenSabor.domain.entities.ArticuloInsumo;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloInsumoRepository extends ArticuloRepository<ArticuloInsumo,Long> {
}
