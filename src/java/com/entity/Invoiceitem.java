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
@Table(name = "invoiceitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoiceitem.findAll", query = "SELECT i FROM Invoiceitem i"),
    @NamedQuery(name = "Invoiceitem.findByInId", query = "SELECT i FROM Invoiceitem i WHERE i.inId = :inId"),
    @NamedQuery(name = "Invoiceitem.findByItem", query = "SELECT i FROM Invoiceitem i WHERE i.item = :item"),
    @NamedQuery(name = "Invoiceitem.findByQuantity", query = "SELECT i FROM Invoiceitem i WHERE i.quantity = :quantity"),
    @NamedQuery(name = "Invoiceitem.findByCost", query = "SELECT i FROM Invoiceitem i WHERE i.cost = :cost")})
public class Invoiceitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inId")
    private Integer inId;
    @Basic(optional = false)
    @Column(name = "item")
    private String item;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "cost")
    private double cost;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoiceitem")
    private Collection<Invoice> invoiceCollection;

    public Invoiceitem() {
    }

    public Invoiceitem(Integer inId) {
        this.inId = inId;
    }

    public Invoiceitem(Integer inId, String item, int quantity, double cost) {
        this.inId = inId;
        this.item = item;
        this.quantity = quantity;
        this.cost = cost;
    }

    public Integer getInId() {
        return inId;
    }

    public void setInId(Integer inId) {
        this.inId = inId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @XmlTransient
    public Collection<Invoice> getInvoiceCollection() {
        return invoiceCollection;
    }

    public void setInvoiceCollection(Collection<Invoice> invoiceCollection) {
        this.invoiceCollection = invoiceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inId != null ? inId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoiceitem)) {
            return false;
        }
        Invoiceitem other = (Invoiceitem) object;
        if ((this.inId == null && other.inId != null) || (this.inId != null && !this.inId.equals(other.inId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Invoiceitem[ inId=" + inId + " ]";
    }
    
}
