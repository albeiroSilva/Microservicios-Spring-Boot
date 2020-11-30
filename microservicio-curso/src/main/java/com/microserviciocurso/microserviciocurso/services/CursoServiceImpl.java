package com.microserviciocurso.microserviciocurso.services;

import com.example.core.commons.services.CommonServiceImpl;
import com.microserviciocurso.microserviciocurso.models.entity.Curso;
import com.microserviciocurso.microserviciocurso.models.repository.CursoRepository;

import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {
    
}
