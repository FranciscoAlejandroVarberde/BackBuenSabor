package com.example.backBuenSabor.presentation.advice.services.Impl;

import com.example.backBuenSabor.repositories.PersonaRepository;
import com.example.backBuenSabor.presentation.advice.services.IPersonaService;
import com.example.backBuenSabor.domain.entities.Persona;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class PersonaServiceImpl <E extends Persona, ID extends Serializable> implements IPersonaService<E, ID> {
    @Autowired
    protected PersonaRepository<E, ID> personaRepository;


    @Override
    @Transactional
    public List<E> findAll()  {
        List<E> entities = personaRepository.findAll();
        return entities;
    }

    @Override
    @Transactional
    public E findById(ID id)  {
        var optionalEntity = personaRepository.findById(id);

        if (optionalEntity.isEmpty()){
            throw new RuntimeException("No se encontro una entidad con el id " + id);
        }
        var entity = optionalEntity.get();
        return entity;
    }

    @Override
    @Transactional
    public E save(E entity)  {
        entity = personaRepository.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public E update(E entity)  {
        var optionalEntity = personaRepository.findById((ID) entity.getId());
        if (optionalEntity.isEmpty()){

            throw new RuntimeException("No se encontro una entidad con el id " + entity.getId());
        }
        var newEntity = personaRepository.save(entity);

        return newEntity;
    }

    @Override
    @Transactional
    public void delete(ID id)  {
        if (personaRepository.existsById(id)) {
            Optional<E> entityOptional = personaRepository.findById(id);

            E ent = entityOptional.get();
            ent.setEstaActivo(false);

            personaRepository.save(ent);

        } else {
            throw new RuntimeException("No se encontro una entidad con el id " + id);
        }
    }
}

