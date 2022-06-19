package org.uv.api.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.uv.api.models.Estudiante;
import org.uv.api.repository.EstudianteRepository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alexisjra
 */
@RestController
public class EstudianteController {
    @Autowired
    EstudianteRepository repository;
    
    @GetMapping("/Estudiante")
    List<Estudiante> getAll(){
        return repository.findAll();
    }
    
    @PostMapping("/Estudiante")
    Estudiante newEstudiante(@RequestBody Estudiante estudiante){
        return repository.save(estudiante);
    }
}
