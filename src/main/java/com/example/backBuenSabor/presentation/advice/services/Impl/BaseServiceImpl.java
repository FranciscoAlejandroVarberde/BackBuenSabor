package com.example.backBuenSabor.presentation.advice.services.Impl;

import com.example.backBuenSabor.repositories.BaseRepository;
import com.example.backBuenSabor.presentation.advice.services.IBaseService;
import com.example.backBuenSabor.domain.entities.Base;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements IBaseService<E, ID> {
    @Autowired
    protected BaseRepository<E, ID> baseRepository;


    @Override
    @Transactional
    public List<E> findAll()  {
        List<E> entities = baseRepository.findAll();
        return entities;
    }

    @Override
    @Transactional
    public E findById(ID id)  {
        var optionalEntity = baseRepository.findById(id);

        if (optionalEntity.isEmpty()){
            throw new RuntimeException("No se encontro una entidad con el id " + id);
        }
        var entity = optionalEntity.get();
        return entity;
    }

    @Override
    @Transactional
    public E save(E entity)  {
        entity = baseRepository.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public E update(E entity)  {
        var optionalEntity = baseRepository.findById((ID) entity.getId());
        if (optionalEntity.isEmpty()){

            throw new RuntimeException("No se encontro una entidad con el id " + entity.getId());
        }
        var newEntity = baseRepository.save(entity);

        return newEntity;
    }

    @Override
    @Transactional
    public void delete(ID id)  {
        if (baseRepository.existsById(id)) {
            Optional<E> entityOptional = baseRepository.findById(id);

            E ent = entityOptional.get();
            ent.setEstaActivo(false);

             baseRepository.save(ent);

        } else {
            throw new RuntimeException("No se encontro una entidad con el id " + id);
        }
    }
}
