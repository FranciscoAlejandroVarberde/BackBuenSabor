package com.example.backBuenSabor.presentation.advice.services;

import com.example.backBuenSabor.domain.entities.Base;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<E extends Base, ID extends Serializable>{
    public List<E> findAll() ;
    public E findById(ID id) ;
    public E save(E entity) ;
    public E update(E entity) ;
    public void delete(ID id) ;
}