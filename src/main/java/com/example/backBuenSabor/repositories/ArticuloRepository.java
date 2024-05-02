package com.example.backBuenSabor.repositories;

import com.example.backBuenSabor.domain.entities.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
@NoRepositoryBean
public interface ArticuloRepository  <E extends Articulo, ID extends Serializable> extends JpaRepository<E, ID> {
}
