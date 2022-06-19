/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.RepasoS203.controlle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alexisjra
 */

//http://localhost:8080/persona/saludo

@RestController
@RequestMapping("/persona")
public class ControllerPersona {
    @GetMapping("/saludo")
    public String saludo(){
        return "Hola mundo GET";
    } 
}
