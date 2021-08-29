/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms.controller;

import java.util.List;
import sms.Model.Student;

/**
 *
 * @author hirwa
 */
public interface IstudentInterface {
    
    public Student save(Student st);
    
    public Student update(Student st);
    
    public Student delete(Student st);
    
    public Student importExcelSheet(Student st);
    
    public List<Student> stList();
    
    public List<Student> findAll(Student st);
}
