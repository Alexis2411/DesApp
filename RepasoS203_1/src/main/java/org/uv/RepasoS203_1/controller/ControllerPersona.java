/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.RepasoS203_1.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.RepasoS203_1.DAO.IRepositoryPersona;
import org.uv.RepasoS203_1.DAO.Persona;

/**
 *
 * @author alexisjra
 */
//http://localhost:8080/persona/saludo

@RestController
@RequestMapping("/persona")
public class ControllerPersona {
    
    @Autowired
    private IRepositoryPersona repositoryPersona;
    
    @GetMapping
    private ResponseEntity<List<Persona>> getAllPersonas(){
        try{
            return ResponseEntity.ok(repositoryPersona.findAll());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }  
    }
    
    @PostMapping
    private ResponseEntity<Persona> savePersona(@RequestBody Persona persona){
        try{
            Persona personaGuardada = repositoryPersona.save(persona);
            return ResponseEntity.created(new URI("/persona/"+personaGuardada.getId())).body(personaGuardada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @PutMapping("/persona/{id}")
    private ResponseEntity<Persona> updatePersona(@PathVariable(value="id") int personaID, @RequestBody Persona personaDetails){
        Persona persona = repositoryPersona.getById(personaID);
        persona.setDireccion(personaDetails.getDireccion());
        persona.setEdad(personaDetails.getEdad());
        persona.setNombre(personaDetails.getNombre());
        persona.setTelefono(personaDetails.getTelefono());
        final Persona updatedPersona = repositoryPersona.save(persona);
        return ResponseEntity.ok(updatedPersona);
    }
//    @GetMapping("/saludo")
//    public String saludo(){
//        return "Hola mundo GET";
//    }    
}