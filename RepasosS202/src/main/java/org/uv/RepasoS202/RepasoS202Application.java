package org.uv.RepasoS202;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.uv.RepasoS202.DAO.IRepositoryPersona;
import org.uv.RepasoS202.DAO.Persona;

@SpringBootApplication
public class RepasoS202Application implements CommandLineRunner {

    @Autowired
    IRepositoryPersona repositoryPersona;

    public static void main(String[] args) {
        SpringApplication.run(RepasoS202Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //System.out.println("hola mundo desde spring boot");
        Scanner sc = new Scanner(System.in);
        int i, id;
//        persona.setNombre("Alexis");
//        persona.setEdad(21);
//        persona.setDireccion("Hidalgo");
//        persona.setTelefono("271749893");
//
//        repositoryPersona.save(persona);
//        System.out.println("Se ah guardado");

        String nombre, direccion, telefono;
        int edad;
        Persona p = new Persona();
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
                p.setNombre(nombre);
                p.setEdad(edad);
                p.setDireccion(direccion);
                p.setTelefono(telefono);
                repositoryPersona.save(p);
                System.out.println("Se guardo");
                break;
            case 2:
                System.out.println("Id: ");
                id = sc.nextInt();
                p = repositoryPersona.getById(id);
                System.out.println("Nombre: " + p.getNombre());
                break;
            case 3:
                System.out.println("Id: ");
                id = sc.nextInt();
                p = repositoryPersona.getById(id);
                System.out.println("Nombre: ");
                p.setNombre("Alex");
                System.out.println("Edad: ");
                p.setEdad(22);
                System.out.println("Direccion: ");
                p.setDireccion("Av2");
                System.out.println("Telefono: ");
                p.setTelefono("2717498938");
                repositoryPersona.save(p);
                System.out.println("Se actualizó");
                break;
            case 4:
                System.out.println("Id: ");
                id = sc.nextInt();
                repositoryPersona.deleteById(id);
                System.out.println("Se eliminó: ");
                break;
            default:
                throw new AssertionError();
        }
    }

}
