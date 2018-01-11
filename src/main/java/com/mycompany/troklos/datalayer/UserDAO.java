/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.troklos.datalayer;

import com.mycompany.troklos.businesslayer.User;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface UserDAO extends CommonDAO {
    public User getById(int id);
    
    public List<User> getAll();        
}
