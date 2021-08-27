/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms.controller;

import java.util.List;
import sms.util.HibernateUtil;
import sms.Model.Courses;
import org.hibernate.*;

/**
 *
 * @author hirwa
 */
public class courseDao {
    Session ss = null;
    public Courses save(Courses cs){
        ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = ss.beginTransaction();
        ss.save(cs);
        tx.commit();
        ss.close();
        return cs;
    }
    
    public Courses update(Courses cs){
        ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = ss.beginTransaction();
        ss.update(cs);
        tx.commit();
        ss.close();
        return cs;
    }
    
    public Courses delete(Courses cs){
        ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = ss.beginTransaction();
        ss.delete(cs);
        tx.commit();
        ss.close();
        return cs;
    }
    
    public List<Courses> displayCourses(){
        ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = ss.beginTransaction();
        List<Courses> cour = (List<Courses>) ss.createCriteria(Courses.class).list();
        tx.commit();
        ss.close();
        return cour;
    }

    /*This method will help us to find and select all students from the database table.*/
    public List<Courses> findAll (Courses crs) {
        ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = ss.beginTransaction();
        List<Courses> allcrs = (List<Courses>) ss.createCriteria(crs.getClass()).list();
        tx.commit();
        ss.close();
        return allcrs;
    }
    /*
    public Courses findCourses (String courseName){
        ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = ss.beginTransaction();
        String sql = "from courses where name='"+courseName+"'";
        Query query = ss.createQuery(sql);
        tx.commit();
        ss.close();
        return (Courses)query.uniqueResult();
    }
*/
}
