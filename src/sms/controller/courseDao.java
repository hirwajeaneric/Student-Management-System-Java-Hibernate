/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms.controller;

import java.util.*;
import org.hibernate.*;

import sms.util.HibernateUtil;
import sms.Model.Courses;

/**
 *
 * @author hirwa
 */

public class courseDao implements IcourseInterface{
    Session ss = null;
    Transaction tx = null;
    
    @Override
    public Courses save(Courses cr){
        ss = HibernateUtil.getSessionFactory().openSession();
        tx = ss.beginTransaction();
        ss.save(cr);
        tx.commit();
        ss.close();
        return cr;
    }
    
    @Override
    public Courses update(Courses cr){
        ss = HibernateUtil.getSessionFactory().openSession();
        tx = ss.beginTransaction();
        ss.update(cr);
        tx.commit();
        ss.close();
        return cr;
    }
    
    @Override
    public Courses delete(Courses cr){
        ss = HibernateUtil.getSessionFactory().openSession();
        tx = ss.beginTransaction();
        ss.delete(cr);
        tx.commit();
        ss.close();
        return cr;
    }
    
    @Override
    public Courses importExcelSheet(Courses cr){    
        ss = HibernateUtil.getSessionFactory().openSession();
        tx = ss.beginTransaction();
        ss.saveOrUpdate(cr);
        tx.commit();
        ss.close();
        return cr;
    }
    
    @Override
    public List<Courses> stList(){
        ss = HibernateUtil.getSessionFactory().openSession();
        tx = ss.beginTransaction();
        Query q = ss.createQuery("From courses");
        List<Courses> sl = q.list();
        ss.getTransaction().commit();
        return sl;
    }

    /*This method will help us to find and select all students from the database table.*/
    @Override
    public List<Courses> findAll (Courses cr) {
        ss = HibernateUtil.getSessionFactory().openSession();
        tx = ss.beginTransaction();
        List<Courses> all = (List<Courses>) ss.createCriteria(cr.getClass()).list();
        tx.commit();
        ss.close();
        return all;
    }
    
}
