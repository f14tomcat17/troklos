/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.troklos.datalayer;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author daniel
 */
public abstract class CommonDAOImpl implements CommonDAO {
    protected Session session;
    
    protected Transaction transaction;

    @Override
    public void openSession() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        session = configuration.buildSessionFactory(builder.build()).openSession();
    }
    
    @Override
    public void closeSession() {
        if(transaction != null) {
            transaction.rollback();
        }
        session.close();
    }
    
    @Override
    public void closeTransaction(boolean commit) {
        if(commit) {
            transaction.commit();
            return;
        }
        transaction.rollback();            
    }
    
    @Override
    public void beginTransaction() {
        if(transaction != null) {
            transaction.rollback();
        }
        transaction = session.beginTransaction();
    }
    
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
    
    @Override
    public void update(Serializable item, Class<?> classType) {        
        session.update(item);        
    }

    @Override
    public void insert(Serializable item, Class<?> classType) {        
        session.save(item);        
    }

    @Override
    public void delete(Serializable item, Class<?> classType) {        
        session.delete(item);        
    }
}
