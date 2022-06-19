/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.ExamenAlumnosProyecto2.Controllers;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.uv.ExamenAlumnosProyecto2.Models.AlumnosAlexis;
import org.uv.ExamenAlumnosProyecto2.Repository.AlumnosRepositoryAlexis;

/**
 *
 * @author alexisjra
 */
@RestController
public class AlumnosControllerAlexis {
     @Autowired
    private AlumnosRepositoryAlexis repository;
    
    @GetMapping("/Alumno")
    ResponseEntity<List<AlumnosAlexis>> getall (){
        return ResponseEntity.ok(repository.findAll());
    }
    
    @PostMapping("/Alumno")
    ResponseEntity<AlumnosAlexis> newAlumno (@RequestBody AlumnosAlexis alumno){
        try {
            AlumnosAlexis alumnoG = repository.save(alumno);
            return ResponseEntity.created(new URI("/Alumno/"+alumnoG.getId())).body(alumnoG);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }       
    }
    
    @GetMapping("/Alumno/{id}")
     ResponseEntity<AlumnosAlexis> getone (@PathVariable Long id){
        return ResponseEntity.ok(repository.getById(id));
    }
    
    @DeleteMapping("/Alumno/{id}")
    void deleteone (@PathVariable Long id){
        repository.deleteById(id);
    }
    
    @PutMapping("/Alumno/{id}")
    ResponseEntity<AlumnosAlexis> update (@RequestBody AlumnosAlexis alumno, @PathVariable Long id){
        AlumnosAlexis esc = repository.getById(id);
        esc.setNombre(alumno.getNombre());
        esc.setTelefono(alumno.getTelefono());
        esc.setSemestre(alumno.getSemestre());
        esc.setCarrera(alumno.getCarrera());
        return ResponseEntity.ok(esc);

   }
}
