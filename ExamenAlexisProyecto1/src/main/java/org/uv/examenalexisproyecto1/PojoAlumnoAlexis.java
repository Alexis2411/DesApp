/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.examenalexisproyecto1;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.Table;

/**
 *
 * @author alexisjra
 */

@Entity
public class PojoAlumnoAlexis {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private int id;
   @Column(name = "nombre")
   private String nombre;
   @Column(name = "telefono")
   private String telefono;
   @Column(name = "semestre")
   private int semestre;
   @Column(name = "carrera")
   private PojoCarrerasAlexis carrera;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public PojoCarrerasAlexis getCarrera() {
        return carrera;
    }

    public void setCarrera(PojoCarrerasAlexis carrera) {
        this.carrera = carrera;
    }
 
}
