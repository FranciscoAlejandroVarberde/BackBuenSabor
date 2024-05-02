package com.example.backBuenSabor.presentation.advice.services.Impl;

import com.example.backBuenSabor.repositories.ArticuloRepository;
import com.example.backBuenSabor.presentation.advice.services.IArticuloService;
import com.example.backBuenSabor.domain.entities.Articulo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class ArticuloServiceImpl<E extends Articulo, ID extends Serializable> implements IArticuloService<E, ID> {
    @Autowired
    protected ArticuloRepository<E, ID> articuloRepository;


    @Override
    @Transactional
    public List<E> findAll()  {
        List<E> entities = articuloRepository.findAll();
        return entities;
    }

    @Override
    @Transactional
    public E findById(ID id)  {
        var optionalEntity = articuloRepository.findById(id);

        if (optionalEntity.isEmpty()){
            throw new RuntimeException("No se encontro una entidad con el id " + id);
        }
        var entity = optionalEntity.get();
        return entity;
    }

    @Override
    @Transactional
    public E save(E entity)  {
        entity = articuloRepository.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public E update(E entity)  {
        var optionalEntity = articuloRepository.findById((ID) entity.getId());
        if (optionalEntity.isEmpty()){

            throw new RuntimeException("No se encontro una entidad con el id " + entity.getId());
        }
        var newEntity = articuloRepository.save(entity);

        return newEntity;
    }

    @Override
    @Transactional
    public void delete(ID id)  {
        if (articuloRepository.existsById(id)) {
            Optional<E> entityOptional = articuloRepository.findById(id);

            E ent = entityOptional.get();
            ent.setEstaActivo(false);

            articuloRepository.save(ent);

        } else {
            throw new RuntimeException("No se encontro una entidad con el id " + id);
        }
    }
}
