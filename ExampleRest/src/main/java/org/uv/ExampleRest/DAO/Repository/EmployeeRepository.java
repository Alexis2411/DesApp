/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.ExampleRest.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uv.ExampleRest.DAO.Employees;

/**
 *
 * @author alexisjra
 */
public interface EmployeeRepository extends JpaRepository<Employees, Long>{
    
}
