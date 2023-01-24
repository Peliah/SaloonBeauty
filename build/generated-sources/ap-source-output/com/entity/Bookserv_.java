package com.entity;

import com.entity.Booking;
import com.entity.Service;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-01-21T19:20:55", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Bookserv.class)
public class Bookserv_ { 

    public static volatile SingularAttribute<Bookserv, Integer> id;
    public static volatile SingularAttribute<Bookserv, Service> serviceid;
    public static volatile SingularAttribute<Bookserv, Booking> bookingid;

}