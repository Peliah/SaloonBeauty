/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pelz
 */
@Entity
@Table(name = "bookserv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookserv.findAll", query = "SELECT b FROM Bookserv b"),
    @NamedQuery(name = "Bookserv.findById", query = "SELECT b FROM Bookserv b WHERE b.id = :id")})
public class Bookserv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "bookingid", referencedColumnName = "bookid")
    @ManyToOne(optional = false)
    private Booking bookingid;
    @JoinColumn(name = "serviceid", referencedColumnName = "serviceid")
    @ManyToOne(optional = false)
    private Service serviceid;

    public Bookserv() {
    }

    public Bookserv(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Booking getBookingid() {
        return bookingid;
    }

    public void setBookingid(Booking bookingid) {
        this.bookingid = bookingid;
    }

    public Service getServiceid() {
        return serviceid;
    }

    public void setServiceid(Service serviceid) {
        this.serviceid = serviceid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookserv)) {
            return false;
        }
        Bookserv other = (Bookserv) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Bookserv[ id=" + id + " ]";
    }
    
}
