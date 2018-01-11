/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.troklos.datalayer;

import com.mycompany.troklos.businesslayer.Request;

/**
 *
 * @author daniel
 */
public interface RequestDAO {
    public Request getById();
    
    public Request getAll();        
}
