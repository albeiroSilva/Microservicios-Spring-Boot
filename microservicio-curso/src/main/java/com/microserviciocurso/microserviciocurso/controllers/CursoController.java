package com.microserviciocurso.microserviciocurso.controllers;

import java.util.List;
import java.util.Optional;

import com.example.core.commons.controllers.CommonControler;
import com.microserviciocurso.microserviciocurso.models.entity.Curso;
import com.microserviciocurso.microserviciocurso.services.CursoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.commonsalumnos.commonsalumnos.models.entity.Alumno;

@RestController
public class CursoController extends CommonControler<Curso,CursoService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Curso curso, @PathVariable Long id){
        Optional<Curso> objOptionalCurso = this.service.findById(id);
        if (!objOptionalCurso.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Curso objCurso = objOptionalCurso.get();
        objCurso.setNombre(curso.getNombre());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(objCurso));

    }

    @PutMapping("/{id}/agregar-alumnos")
    public ResponseEntity<?> agregarAlumnos(@RequestBody List<Alumno> alumnos, @PathVariable Long id){
        Optional<Curso> objOptionalCurso = this.service.findById(id);
        if (!objOptionalCurso.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Curso objCurso = objOptionalCurso.get();

       // for (int i = 0; i < alumnos.size(); i++) {
         //   objCurso.addAlumno(alumnos.get(i));
        //}
        alumnos.forEach(a -> {
            objCurso.addAlumno(a);
        });
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(objCurso));

    }

    @PutMapping("/{id}/eliminar-alumno")
    public ResponseEntity<?> eiminarAlumno(@RequestBody Alumno alumno, @PathVariable Long id){
        Optional<Curso> objOptionalCurso = this.service.findById(id);
        if (!objOptionalCurso.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Curso objCurso = objOptionalCurso.get();

        objCurso.removeAlumno(alumno);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(objCurso));

    }
    
}