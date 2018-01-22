/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.troklos.servicelayer;

import com.mycompany.troklos.businesslayer.Request;
import com.mycompany.troklos.datalayer.RequestDAO;
import com.mycompany.troklos.datalayer.RequestDAOImpl;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author daniel
 */
@Service
public class RequestService extends CommonService {
    
    public RequestService() {
        dao = new RequestDAOImpl();
    }
    
    public List getAll() {
        List listaRequests;
        dao.beginTransaction();
        listaRequests = ((RequestDAO) dao).getAll();
        dao.closeTransaction(true);
        return listaRequests;
    }
    
    public Request getById(int id) {
        Request r;
        dao.beginTransaction();
        r = ((RequestDAO) dao).getById(id);
        dao.closeTransaction(true);
        return r;
    } 
}
