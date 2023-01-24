package com.entity;

import com.entity.Booking;
import com.entity.Invoiceitem;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-01-21T19:20:55", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Invoice.class)
public class Invoice_ { 

    public static volatile SingularAttribute<Invoice, Date> inDate;
    public static volatile SingularAttribute<Invoice, Invoiceitem> invoiceitem;
    public static volatile SingularAttribute<Invoice, Integer> invoiceid;
    public static volatile SingularAttribute<Invoice, String> invoiceno;
    public static volatile SingularAttribute<Invoice, Booking> bookingid;

}