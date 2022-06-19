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
import org.uv.ExamenAlumnosProyecto2.Models.CarrerasAlexis;
import org.uv.ExamenAlumnosProyecto2.Repository.AlumnosRepositoryAlexis;
import org.uv.ExamenAlumnosProyecto2.Repository.CarrerasRepositoryAlexis;

/**
 *
 * @author alexisjra
 */
@RestController
public class CarrerasControllerAlexis {
     @Autowired
    private CarrerasRepositoryAlexis repository;
    
    @GetMapping("/Carreras")
    ResponseEntity<List<CarrerasAlexis>> getall (){
        return ResponseEntity.ok(repository.findAll());
    }
    
    @PostMapping("/Carreras")
    ResponseEntity<CarrerasAlexis> newCarrera (@RequestBody CarrerasAlexis carrera){
        try {
            CarrerasAlexis carreraG = repository.save(carrera);
            return ResponseEntity.created(new URI("/Carreas/"+carreraG.getId())).body(carreraG);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }       
    }
    
    @GetMapping("/Carreras/{id}")
     ResponseEntity<CarrerasAlexis> getone (@PathVariable Long id){
        return ResponseEntity.ok(repository.getById(id));
    }
    
    @DeleteMapping("/Carreras/{id}")
    void deleteone (@PathVariable Long id){
        repository.deleteById(id);
    }
    
    @PutMapping("/Carreras/{id}")
    ResponseEntity<CarrerasAlexis> update (@RequestBody CarrerasAlexis carrera, @PathVariable Long id){
        CarrerasAlexis esc = repository.getById(id);
        esc.setNombre(carrera.getNombre());
        return ResponseEntity.ok(esc);

   }
}
