/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.troklos.datalayer;

import com.mycompany.troklos.businesslayer.User;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author daniel
 */
public class UserDAOImpl extends CommonDAOImpl implements UserDAO {

    @Override
    public User getById(int id) {
        return (User) session.get(User.class, id);
    }

    @Override
    public List getAll() {
        return session.createQuery("select new map(u.name as name, u.surname as surname, concat('localhost:8080/AdoracionTroklosRest/users/', u.iduser) as urlItem) from User u").list();
    }       
}
