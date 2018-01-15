/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.troklos.datalayer;

import com.mycompany.troklos.businesslayer.Request;
import java.util.List;

/**
 *
 * @author daniel
 */
public class RequestDAOImpl extends CommonDAOImpl implements RequestDAO {

    @Override
    public Request getById(int id) {
        return (Request) session.get(Request.class, id);
    }

    @Override
    public List<Request> getAll() {
        return session.createCriteria(Request.class).list();        
    }  
    
    
}
