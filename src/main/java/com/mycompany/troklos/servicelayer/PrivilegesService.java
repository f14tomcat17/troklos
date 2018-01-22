/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.troklos.servicelayer;

import com.mycompany.troklos.businesslayer.Privileges;
import com.mycompany.troklos.datalayer.PrivilegesDAO;
import com.mycompany.troklos.datalayer.PrivilegesDAOImpl;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author daniel
 */
@Service
public class PrivilegesService extends CommonService {
    
    public PrivilegesService() {
        dao = new PrivilegesDAOImpl();
    }
    
    public List getAll() {
        List<Privileges> listaPrivileges;
        dao.beginTransaction();
        listaPrivileges = ((PrivilegesDAO) dao).getAll();
        dao.closeTransaction(true);
        return listaPrivileges;
    }
    
    public Privileges getById(int id) {
        Privileges r;
        dao.beginTransaction();
        r = ((PrivilegesDAO) dao).getById(id);
        dao.closeTransaction(true);
        return r;
    } 
}
