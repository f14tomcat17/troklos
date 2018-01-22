/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.troklos.servicelayer;

import com.mycompany.troklos.datalayer.CommonDAO;
import java.io.Serializable;




/**
 *
 * @author daniel
 */
public abstract class CommonService {
    
    protected CommonDAO dao;   
        
    public void update(Serializable item) {
        dao.beginTransaction();
        dao.update(item);
        dao.closeTransaction(true);
    }
    
    public void insert(Serializable item) {
        dao.beginTransaction();
        dao.insert(item);
        dao.closeTransaction(true);
    }
    
    public void delete(Serializable item) {
        dao.beginTransaction();
        dao.delete(item);
        dao.closeTransaction(true);
    }
}
