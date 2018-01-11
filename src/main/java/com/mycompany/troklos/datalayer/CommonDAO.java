/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.troklos.datalayer;

import java.io.Serializable;

/**
 *
 * @author daniel
 */
public interface CommonDAO {
    public void openSession();
    
    public void closeSession();
    
    public void closeTransaction(boolean commit);
    
    public void beginTransaction();
    
    public void update(Serializable item, Class<?> classType);
    
    public void insert(Serializable item, Class<?> classType);
    
    public void delete(Serializable item, Class<?> classType);
}
