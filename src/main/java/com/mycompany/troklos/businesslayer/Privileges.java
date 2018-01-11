/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.troklos.businesslayer;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "privileges")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Privileges.findAll", query = "SELECT p FROM Privileges p"),
    @NamedQuery(name = "Privileges.findByIdprivileges", query = "SELECT p FROM Privileges p WHERE p.idprivileges = :idprivileges"),
    @NamedQuery(name = "Privileges.findByName", query = "SELECT p FROM Privileges p WHERE p.name = :name")})
public class Privileges implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprivileges")
    private Integer idprivileges;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "privilegesId", fetch = FetchType.LAZY)
    private Collection<User> userCollection;

    public Privileges() {
    }

    public Privileges(Integer idprivileges) {
        this.idprivileges = idprivileges;
    }

    public Privileges(Integer idprivileges, String name) {
        this.idprivileges = idprivileges;
        this.name = name;
    }

    public Integer getIdprivileges() {
        return idprivileges;
    }

    public void setIdprivileges(Integer idprivileges) {
        this.idprivileges = idprivileges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprivileges != null ? idprivileges.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privileges)) {
            return false;
        }
        Privileges other = (Privileges) object;
        if ((this.idprivileges == null && other.idprivileges != null) || (this.idprivileges != null && !this.idprivileges.equals(other.idprivileges))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.troklos.datalayer.Privileges[ idprivileges=" + idprivileges + " ]";
    }
    
}
