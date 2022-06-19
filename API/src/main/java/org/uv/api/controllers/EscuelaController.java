/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.api.controllers;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.api.models.Escuela;
import org.uv.api.repository.EscuelaRepository;

/**
 *
 * @author alexisjra
 */
@RestController
public class EscuelaController {
    @Autowired
    private EscuelaRepository repository;
    
    @GetMapping("/Escuela")
    ResponseEntity<List<Escuela>> getall (){
        return ResponseEntity.ok(repository.findAll());
    }
    
    @PostMapping("/Escuela")
    ResponseEntity<Escuela> newEscuela (@RequestBody Escuela escuela){
        Escuela escuelaG = repository.save(escuela);
        return ResponseEntity.created(new URI("/Escuela/"+escuelaG.getId())).body(escuelaG));
    }
    
    @GetMapping("/Escuela/{id}")
    Escuela getone (@PathVariable Long id){
        return repository.getById(id);
    }
    
    @DeleteMapping("/Escuela/{id}")
    void deleteone (@PathVariable Long id){
        repository.deleteById(id);
    }
    
    @PutMapping("/Escuela/{id}")
    Escuela update (@RequestBody Escuela escuela, @PathVariable Long id){
        Escuela esc = repository.getById(id);
        esc.setNombre(escuela.getNombre());
        esc.setDireccion(escuela.getDireccion());
        esc.setTelefono(escuela.getTelefono());
        return repository.save(esc);
    }
}
