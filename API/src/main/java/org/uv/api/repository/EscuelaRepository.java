/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uv.api.models.Escuela;

/**
 *
 * @author alexisjra
 */
@Repository
public interface EscuelaRepository extends JpaRepository<Escuela, Long>{
    
}
