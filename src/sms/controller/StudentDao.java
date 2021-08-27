/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms.controller;

import java.io.*;
import java.util.*;
import java.util.logging.*;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.*;

import sms.util.HibernateUtil;
import sms.Model.Student;
import sms.view.StudentRegistration;

/**
 *
 * @author hirwa
 */

public class StudentDao {
    Session ss = null;
    Transaction tx = null;
    
    public void save(Student st){
        ss = HibernateUtil.getSessionFactory().openSession();
        tx = ss.beginTransaction();
        ss.save(st);
        tx.commit();
        ss.close();
    }
    
    public void update(Student st){
        ss = HibernateUtil.getSessionFactory().openSession();
        tx = ss.beginTransaction();
        ss.update(st);
        tx.commit();
        ss.close();
    }
    
    public void delete(Student st){
        ss = HibernateUtil.getSessionFactory().openSession();
        tx = ss.beginTransaction();
        ss.delete(st);
        tx.commit();
        ss.close();
    }
    
    
    public void importExcelSheet(Student st){    
        ss = HibernateUtil.getSessionFactory().openSession();
        tx = ss.beginTransaction();
        ss.saveOrUpdate(st);
        tx.commit();
        ss.close();
    }
    
    public List<Student> stList(){
        ss = HibernateUtil.getSessionFactory().openSession();
        tx = ss.beginTransaction();
        Query q = ss.createQuery("From Student");
        List<Student> sl = q.list();
        ss.getTransaction().commit();
        return sl;
    }

    /*This method will help us to find and select all students from the database table.*/
    public List<Student> findAll (Student st) {
        ss = HibernateUtil.getSessionFactory().openSession();
        tx = ss.beginTransaction();
        List<Student> all = (List<Student>) ss.createCriteria(st.getClass()).list();
        tx.commit();
        ss.close();
        return all;
    }
    
    public void exportPdf() {
        
    }
    
}