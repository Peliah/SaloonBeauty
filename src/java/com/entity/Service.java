/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pelz
 */
@Entity
@Table(name = "service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s"),
    @NamedQuery(name = "Service.findByServiceid", query = "SELECT s FROM Service s WHERE s.serviceid = :serviceid"),
    @NamedQuery(name = "Service.findByServicename", query = "SELECT s FROM Service s WHERE s.servicename = :servicename"),
    @NamedQuery(name = "Service.findByServicedesc", query = "SELECT s FROM Service s WHERE s.servicedesc = :servicedesc"),
    @NamedQuery(name = "Service.findByPrice", query = "SELECT s FROM Service s WHERE s.price = :price")})
public class Service implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "serviceid")
    private Integer serviceid;
    @Basic(optional = false)
    @Column(name = "servicename")
    private String servicename;
    @Basic(optional = false)
    @Column(name = "servicedesc")
    private String servicedesc;
    @Basic(optional = false)
    @Column(name = "price")
    private double price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceid")
    private Collection<Servemp> servempCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceid")
    private Collection<Bookserv> bookservCollection;

    public Service() {
    }

    public Service(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public Service(Integer serviceid, String servicename, String servicedesc, double price) {
        this.serviceid = serviceid;
        this.servicename = servicename;
        this.servicedesc = servicedesc;
        this.price = price;
    }

    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getServicedesc() {
        return servicedesc;
    }

    public void setServicedesc(String servicedesc) {
        this.servicedesc = servicedesc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<Servemp> getServempCollection() {
        return servempCollection;
    }

    public void setServempCollection(Collection<Servemp> servempCollection) {
        this.servempCollection = servempCollection;
    }

    @XmlTransient
    public Collection<Bookserv> getBookservCollection() {
        return bookservCollection;
    }

    public void setBookservCollection(Collection<Bookserv> bookservCollection) {
        this.bookservCollection = bookservCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceid != null ? serviceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.serviceid == null && other.serviceid != null) || (this.serviceid != null && !this.serviceid.equals(other.serviceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Service[ serviceid=" + serviceid + " ]";
    }
    
}
