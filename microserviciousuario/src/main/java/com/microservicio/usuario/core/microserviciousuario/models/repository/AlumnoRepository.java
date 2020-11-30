package com.microservicio.usuario.core.microserviciousuario.models.repository;

import java.util.List;

import com.commonsalumnos.commonsalumnos.models.entity.Alumno;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
    
    @Query("select a from Alumno a where a.nombre like %?1% or a.apellido like %?1%")
    public List<Alumno> findByNombreOrApellido(String term);
}