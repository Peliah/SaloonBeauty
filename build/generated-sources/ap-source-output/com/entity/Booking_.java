package com.entity;

import com.entity.Bookserv;
import com.entity.Customer;
import com.entity.Invoice;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-01-21T19:20:55", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Booking.class)
public class Booking_ { 

    public static volatile SingularAttribute<Booking, Date> bookdate;
    public static volatile SingularAttribute<Booking, Customer> customerid;
    public static volatile CollectionAttribute<Booking, Bookserv> bookservCollection;
    public static volatile SingularAttribute<Booking, Date> endtime;
    public static volatile SingularAttribute<Booking, Date> starttime;
    public static volatile SingularAttribute<Booking, Invoice> invoice;
    public static volatile SingularAttribute<Booking, Integer> bookid;

}