/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.troklos.datalayer;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 *
 * @author daniel
 */
public interface CommonDAO extends InitializingBean, DisposableBean {
    public void openSession();
    
    public void closeSession();
    
    public void closeTransaction(boolean commit);
    
    public void beginTransaction();
    
    public List getAll();
    
    public void update(Serializable item);
    
    public void insert(Serializable item);
    
    public void delete(Serializable item);
}
