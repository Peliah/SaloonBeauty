package com.entity;

import com.entity.Booking;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-01-21T19:20:55", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> firstname;
    public static volatile SingularAttribute<Customer, String> passwd;
    public static volatile SingularAttribute<Customer, Integer> custid;
    public static volatile SingularAttribute<Customer, Integer> phonenumber;
    public static volatile CollectionAttribute<Customer, Booking> bookingCollection;
    public static volatile SingularAttribute<Customer, String> email;
    public static volatile SingularAttribute<Customer, String> lastname;
    public static volatile SingularAttribute<Customer, String> username;

}