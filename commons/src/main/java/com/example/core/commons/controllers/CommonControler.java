package com.example.core.commons.controllers;

import java.util.Optional;

import com.example.core.commons.services.CommonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



public class CommonControler<E, S extends CommonService<E>> {

    @Autowired
    protected S service;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id) {
        Optional<E> objOptional = service.findById(id);
        if (objOptional.isPresent()) {
            return ResponseEntity.ok(objOptional.get());
            
        }else{
            return ResponseEntity.notFound().build();
        }
        
    }
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody E entity){
        E objEntity= service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(objEntity);
    }

   

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}