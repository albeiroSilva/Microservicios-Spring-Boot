package com.microservicio.usuario.core.microserviciousuario.services;

import java.util.List;

import com.commonsalumnos.commonsalumnos.models.entity.Alumno;
import com.example.core.commons.services.CommonService;


public interface AlumnoService extends CommonService<Alumno> {
    
    public List<Alumno> findByNombreOrApellido(String term);
}