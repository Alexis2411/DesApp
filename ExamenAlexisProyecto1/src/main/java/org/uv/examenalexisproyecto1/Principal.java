/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.examenalexisproyecto1;

import java.util.Scanner;

/**
 *
 * @author alexisjra
 */
public class Principal {
    public static void main(String[] args){
        
        DAOAlumnoAlexis daoa = new DAOAlumnoAlexis();
        DAOCarrerasAlexis daoc = new DAOCarrerasAlexis();
        
        Scanner sc = new Scanner(System.in);
        int i, id;
        String nombre, direccion, telefono;
        int edad;
        
        PojoAlumnoAlexis a = new PojoAlumnoAlexis();
        PojoCarrerasAlexis c = new PojoCarrerasAlexis();
        
        System.out.println("Opcion: ");
        i = sc.nextInt();
        switch (i) {
            case 1:
                System.out.println("Nombre: ");
                nombre = "Alexis";
                System.out.println("Edad: ");
                edad = 21;
                System.out.println("Direccion: ");
                direccion = "Av 1";
                System.out.println("Telefono: ");
                telefono = "2711274201";
                a.setNombre(nombre);
                a.setTelefono(telefono);
                a.setCarrera(c);
                daoa.guardar(a);
                System.out.println("Se guardo");
                break;
            case 2:
                System.out.println("Id: ");
                id = sc.nextInt();
                a = daoa.buscarById(id);
                System.out.println("Nombre: " + a.getNombre());
                break;
            case 3:
                System.out.println("Id: ");
                id = sc.nextInt();
                a = daoa.buscarById(id);
                System.out.println("Nombre: ");
                a.setNombre("Alex");
                System.out.println("Telefono: ");
                a.setTelefono("2717498938");
                daoa.guardar(a);
                System.out.println("Se actualizó");
                break;
            case 4:
                System.out.println("Id: ");
                id = sc.nextInt();
                daoa.eliminar(id);
                System.out.println("Se eliminó: ");
                break;
            default:
                throw new AssertionError();
        }
    }
    
}
