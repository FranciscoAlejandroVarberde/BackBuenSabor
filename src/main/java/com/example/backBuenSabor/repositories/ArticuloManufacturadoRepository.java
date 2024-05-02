package com.example.backBuenSabor.repositories;

import com.example.backBuenSabor.domain.entities.ArticuloManufacturado;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloManufacturadoRepository extends ArticuloRepository<ArticuloManufacturado,Long> {
}
