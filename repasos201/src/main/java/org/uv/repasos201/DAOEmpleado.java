/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.repasos201;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author alexis
 */
public class DAOEmpleado {
    public boolean guardar(Empleado empleado){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(empleado);
        transaction.commit();
        session.close();
        return true;
    }
    public boolean eliminar(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Empleado empleado = new Empleado();
        empleado.setClave(id);
        session.delete(empleado);
        transaction.commit();
        session.close();
        return true;
    }
    public boolean modificar(Empleado empleado){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(empleado);
        transaction.commit();
        session.close();
        return true;
    }
    public Empleado buscarById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Empleado empleado = (Empleado)session.get(Empleado.class, id);
        transaction.commit();
        session.close();
        return empleado;
    }
    public List<Empleado> buscarAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Empleado> lsEmpleados;
        lsEmpleados = session.createCriteria(Empleado.class).list();
        transaction.commit();
        session.close();
        return lsEmpleados;    
    }
}
