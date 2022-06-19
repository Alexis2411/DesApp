/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.examenalexisproyecto1;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author alexisjra
 */
public class DAOCarrerasAlexis {
    
    public boolean guardar(PojoCarrerasAlexis carrera){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(carrera);
        transaction.commit();
        session.close();
        return true;
    }
    public boolean eliminar(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        PojoCarrerasAlexis carrera = new PojoCarrerasAlexis();
        carrera.setId(id);
        session.delete(carrera);
        transaction.commit();
        session.close();
        return true;
    }
    public boolean modificar(PojoCarrerasAlexis carrera){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(carrera);
        transaction.commit();
        session.close();
        return true;
    }
    public PojoCarrerasAlexis buscarById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        PojoCarrerasAlexis carrera = (PojoCarrerasAlexis)session.get(PojoCarrerasAlexis.class, id);
        transaction.commit();
        session.close();
        return carrera;
    }
    public List<PojoCarrerasAlexis> buscarAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<PojoCarrerasAlexis> lsCarrera;
        lsCarrera = session.createCriteria(PojoCarrerasAlexis.class).list();
        transaction.commit();
        session.close();
        return lsCarrera;    
    }
}
