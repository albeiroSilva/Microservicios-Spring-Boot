package com.microservicio.usuario.core.microserviciousuario.services;

import java.util.List;

import com.commonsalumnos.commonsalumnos.models.entity.Alumno;
import com.example.core.commons.services.CommonServiceImpl;
import com.microservicio.usuario.core.microserviciousuario.models.repository.AlumnoRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {

    @Override
    @Transactional(readOnly = true)
    public List<Alumno> findByNombreOrApellido(String term) {
        return objRepository.findByNombreOrApellido(term);
    }

    
}