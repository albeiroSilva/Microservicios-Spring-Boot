package com.microserviciocurso.microserviciocurso.models.repository;

import com.microserviciocurso.microserviciocurso.models.entity.Curso;

import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso, Long> {
    
}