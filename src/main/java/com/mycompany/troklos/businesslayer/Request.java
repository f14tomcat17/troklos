/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.troklos.businesslayer;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Request.findAll", query = "SELECT r FROM Request r"),
    @NamedQuery(name = "Request.findByIdrequest", query = "SELECT r FROM Request r WHERE r.idrequest = :idrequest"),
    @NamedQuery(name = "Request.findByDescription", query = "SELECT r FROM Request r WHERE r.description = :description"),
    @NamedQuery(name = "Request.findByRequestDate", query = "SELECT r FROM Request r WHERE r.requestDate = :requestDate"),
    @NamedQuery(name = "Request.findByExpDate", query = "SELECT r FROM Request r WHERE r.expDate = :expDate"),
    @NamedQuery(name = "Request.findByStatus", query = "SELECT r FROM Request r WHERE r.status = :status")})
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idrequest")
    private Integer idrequest;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "requestDate")
    private String requestDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "expDate")
    private String expDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User iduser;

    public Request() {
    }

    public Request(Integer idrequest) {
        this.idrequest = idrequest;
    }

    public Request(Integer idrequest, String description, String requestDate, String expDate, int status) {
        this.idrequest = idrequest;
        this.description = description;
        this.requestDate = requestDate;
        this.expDate = expDate;
        this.status = status;
    }

    public Integer getIdrequest() {
        return idrequest;
    }

    public void setIdrequest(Integer idrequest) {
        this.idrequest = idrequest;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrequest != null ? idrequest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Request)) {
            return false;
        }
        Request other = (Request) object;
        if ((this.idrequest == null && other.idrequest != null) || (this.idrequest != null && !this.idrequest.equals(other.idrequest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.troklos.datalayer.Request[ idrequest=" + idrequest + " ]";
    }
    
}
