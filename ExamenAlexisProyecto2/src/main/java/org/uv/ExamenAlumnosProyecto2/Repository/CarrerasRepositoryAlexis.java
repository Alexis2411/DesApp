/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.ExamenAlumnosProyecto2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uv.ExamenAlumnosProyecto2.Models.CarrerasAlexis;

/**
 *
 * @author alexisjra
 */
@Repository
public interface CarrerasRepositoryAlexis extends JpaRepository<CarrerasAlexis, Long> {
    
}
