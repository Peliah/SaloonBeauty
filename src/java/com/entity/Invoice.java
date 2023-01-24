/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pelz
 */
@Entity
@Table(name = "invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i"),
    @NamedQuery(name = "Invoice.findByInvoiceid", query = "SELECT i FROM Invoice i WHERE i.invoiceid = :invoiceid"),
    @NamedQuery(name = "Invoice.findByInDate", query = "SELECT i FROM Invoice i WHERE i.inDate = :inDate"),
    @NamedQuery(name = "Invoice.findByInvoiceno", query = "SELECT i FROM Invoice i WHERE i.invoiceno = :invoiceno"),
    @NamedQuery(name = "Invoice.findByBookingid", query = "SELECT i FROM Invoice i WHERE i.bookingid = :bookingid")})
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "invoiceid")
    private Integer invoiceid;
    @Basic(optional = false)
    @Column(name = "inDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inDate;
    @Basic(optional = false)
    @Column(name = "invoiceno")
    private String invoiceno;
    @Basic(optional = false)
    @Column(name = "bookingid")
    @OneToOne
    private Booking bookingid;
    @JoinColumn(name = "invoiceitem", referencedColumnName = "inId")
    @ManyToOne(optional = false)
    private Invoiceitem invoiceitem;

    public Invoice() {
    }

    public Invoice(Integer invoiceid) {
        this.invoiceid = invoiceid;
    }

    public Invoice(Integer invoiceid, Date inDate, String invoiceno, Booking bookingid) {
        this.invoiceid = invoiceid;
        this.inDate = inDate;
        this.invoiceno = invoiceno;
        this.bookingid = bookingid;
    }

    public Integer getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(Integer invoiceid) {
        this.invoiceid = invoiceid;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public String getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(String invoiceno) {
        this.invoiceno = invoiceno;
    }

    public Booking getBookingid() {
        return bookingid;
    }

    public void setBookingid(Booking bookingid) {
        this.bookingid = bookingid;
    }

    public Invoiceitem getInvoiceitem() {
        return invoiceitem;
    }

    public void setInvoiceitem(Invoiceitem invoiceitem) {
        this.invoiceitem = invoiceitem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceid != null ? invoiceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.invoiceid == null && other.invoiceid != null) || (this.invoiceid != null && !this.invoiceid.equals(other.invoiceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Invoice[ invoiceid=" + invoiceid + " ]";
    }
    
}
