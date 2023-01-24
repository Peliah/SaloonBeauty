/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pelz
 */
@Entity
@Table(name = "booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "Booking.findByBookid", query = "SELECT b FROM Booking b WHERE b.bookid = :bookid"),
    @NamedQuery(name = "Booking.findByBookdate", query = "SELECT b FROM Booking b WHERE b.bookdate = :bookdate"),
    @NamedQuery(name = "Booking.findByStarttime", query = "SELECT b FROM Booking b WHERE b.starttime = :starttime"),
    @NamedQuery(name = "Booking.findByEndtime", query = "SELECT b FROM Booking b WHERE b.endtime = :endtime")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bookid")
    private Integer bookid;
    @Basic(optional = false)
    @Column(name = "bookdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookdate;
    @Basic(optional = false)
    @Column(name = "starttime")
    @Temporal(TemporalType.TIME)
    private Date starttime;
    @Basic(optional = false)
    @Column(name = "endtime")
    @Temporal(TemporalType.TIME)
    private Date endtime;
    @JoinColumn(name = "customerid", referencedColumnName = "custid")
    @ManyToOne(optional = false)
    private Customer customerid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingid")
    private Collection<Bookserv> bookservCollection;
    @OneToOne(mappedBy = "bookingid")
    private Invoice invoice;

    public Booking() {
    }

    public Booking(Integer bookid) {
        this.bookid = bookid;
    }

    public Booking(Integer bookid, Date bookdate, Date starttime, Date endtime) {
        this.bookid = bookid;
        this.bookdate = bookdate;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Date getBookdate() {
        return bookdate;
    }

    public void setBookdate(Date bookdate) {
        this.bookdate = bookdate;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
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
        hash += (bookid != null ? bookid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bookid == null && other.bookid != null) || (this.bookid != null && !this.bookid.equals(other.bookid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Booking[ bookid=" + bookid + " ]";
    }
    
}
