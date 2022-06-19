/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uv.api.models.Estudiante;

/**
 *
 * @author alexisjra
 */
@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{
    
}
