package com.microservicio.usuario.core.microserviciousuario.controllers;

import java.util.Optional;

import com.commonsalumnos.commonsalumnos.models.entity.Alumno;
import com.example.core.commons.controllers.CommonControler;
import com.microservicio.usuario.core.microserviciousuario.services.AlumnoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AlumnoControler extends CommonControler<Alumno, AlumnoService>{


    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Alumno alumno, @PathVariable Long id){
        Optional<Alumno> objOptional = service.findById(id);
        if (objOptional.isPresent()) {

            Alumno objAlumno = objOptional.get();
            objAlumno.setNombre(alumno.getNombre());
            objAlumno.setApellido(alumno.getApellido());
            objAlumno.setEmail(alumno.getEmail());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(objAlumno));

        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/filtrar/{term}")
    public ResponseEntity<?> filtrar(@PathVariable String term){
        return ResponseEntity.ok(service.findByNombreOrApellido(term));
    }
 
   
}