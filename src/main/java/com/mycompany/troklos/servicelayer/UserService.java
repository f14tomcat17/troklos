/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.troklos.servicelayer;

import com.mycompany.troklos.businesslayer.User;
import com.mycompany.troklos.datalayer.UserDAO;
import com.mycompany.troklos.datalayer.UserDAOImpl;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author daniel
 */
@Service
public class UserService extends CommonService {    
    
    public UserService() {
        dao = new UserDAOImpl();
    }
    
    public List<User> getAll() {
        List<User> listaUsers;
        dao.beginTransaction();
        listaUsers = ((UserDAO) dao).getAll();
        dao.closeTransaction(true);
        return listaUsers;
    }
    
    public User getById(int id) {
        User u;
        dao.beginTransaction();
        u = ((UserDAO) dao).getById(id);
        dao.closeTransaction(true);
        return u;
    }        
}
