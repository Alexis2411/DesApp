/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.repasos201;
/**
 *
 * @author alexis
 */
public class Principal {
    public static void main(String[] args) {
        Empleado empleado = new Empleado();
        empleado.setClave(2);
        empleado.setNombre("Juan 1");
        empleado.setDireccion("Av1");
        empleado.setTelefono("5555");
        DAOEmpleado daoe = new DAOEmpleado();
        daoe.guardar(empleado);
    }
}
