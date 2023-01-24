package com.entity;

import com.entity.Employee;
import com.entity.Service;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-01-21T19:20:55", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Servemp.class)
public class Servemp_ { 

    public static volatile SingularAttribute<Servemp, Integer> id;
    public static volatile SingularAttribute<Servemp, Service> serviceid;
    public static volatile SingularAttribute<Servemp, Employee> employeeid;

}