/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms.controller;

import java.util.List;
import sms.Model.Courses;

/**
 *
 * @author hirwa
 */
public interface IcourseInterface {
    
    public Courses save(Courses cr);
    
    public Courses update(Courses cr);
    
    public Courses delete(Courses cr);
    
    public Courses importExcelSheet(Courses cr);
    
    public List<Courses> stList();
    
    public List<Courses> findAll(Courses cr);
}
