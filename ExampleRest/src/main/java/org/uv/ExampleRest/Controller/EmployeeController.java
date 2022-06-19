/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.ExampleRest.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.ExampleRest.DAO.Employees;
import org.uv.ExampleRest.DAO.Repository.EmployeeRepository;

/**
 *
 * @author alexisjra
 */
@RestController 
public class EmployeeController {
    private final EmployeeRepository repository;

    EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping("/employees")
    List<Employees> all(){
        return repository.findAll();
    }
    
    @PostMapping("/employees")
    Employees newEmployees(@RequestBody Employees newEmployees){
        return repository.save(newEmployees);
    }
    
    @GetMapping("/employees/{id}")
    Optional<Employees> one (@PathVariable Long id){
        return repository.findById(id);
    }
    
    @PutMapping("/employees/{id}")
    ResponseEntity<Employees> updateEmployee(@PathVariable(value="id") Long id, @RequestBody Employees updatedEmployees){
        Employees employee = repository.getById(id);
        employee.setDireccion(updatedEmployees.getDireccion());
        employee.setNombre(updatedEmployees.getNombre());
        final Employees updatedPersona = repository.save(employee);
        return ResponseEntity.ok(updatedPersona);
    }
    
    @DeleteMapping("/employees/{id}")
    void deleteEmployees(@PathVariable Long id){
        repository.deleteById(id);
    }
}
