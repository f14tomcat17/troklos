/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.troklos.datalayer;

import com.mycompany.troklos.businesslayer.Privileges;
import java.util.List;

/**
 *
 * @author daniel
 */
public class PrivilegesDAOImpl extends CommonDAOImpl implements PrivilegesDAO {

    @Override
    public Privileges getById(int id) {
        return (Privileges) session.get(Privileges.class, id);
    }

    @Override
    public List<Privileges> getAll() {
        return session.createCriteria(Privileges.class).list();        
    }
      
}
