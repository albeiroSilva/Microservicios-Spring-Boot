package com.example.core.commons.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommonServiceImpl<E, R extends CrudRepository<E, Long>> implements CommonService<E> {

    @Autowired
    protected R objRepository;

    @Override
    @Transactional(readOnly=true)
    public Iterable<E> findAll() {
        return objRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<E> findById(Long id) {
        return objRepository.findById(id);
    }

    @Override
    @Transactional
    public E save(E entity) {
        return objRepository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        objRepository.deleteById(id);
    }

    
}