/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.troklos.datalayer;

import com.mycompany.troklos.businesslayer.Privileges;

/**
 *
 * @author daniel
 */
public interface PrivilegesDAO extends CommonDAO {
    public Privileges getById(int id);
                
}
