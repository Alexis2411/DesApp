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
public class DAOAlumnoAlexis {
    public boolean guardar(PojoAlumnoAlexis alumno){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(alumno);
        transaction.commit();
        session.close();
        return true;
    }
    public boolean eliminar(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        PojoAlumnoAlexis alumno = new PojoAlumnoAlexis();
        alumno.setId(id);
        session.delete(alumno);
        transaction.commit();
        session.close();
        return true;
    }
    public boolean modificar(PojoAlumnoAlexis alumno){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(alumno);
        transaction.commit();
        session.close();
        return true;
    }
    public PojoAlumnoAlexis buscarById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        PojoAlumnoAlexis alumno = (PojoAlumnoAlexis)session.get(PojoAlumnoAlexis.class, id);
        transaction.commit();
        session.close();
        return alumno;
    }
    public List<PojoAlumnoAlexis> buscarAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<PojoAlumnoAlexis> lsAlumnos;
        lsAlumnos = session.createCriteria(PojoAlumnoAlexis.class).list();
        transaction.commit();
        session.close();
        return lsAlumnos;    
    }
}
