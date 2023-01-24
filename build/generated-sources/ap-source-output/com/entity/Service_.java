package com.entity;

import com.entity.Bookserv;
import com.entity.Servemp;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-01-21T19:20:55", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Service.class)
public class Service_ { 

    public static volatile SingularAttribute<Service, String> servicedesc;
    public static volatile SingularAttribute<Service, Double> price;
    public static volatile CollectionAttribute<Service, Servemp> servempCollection;
    public static volatile CollectionAttribute<Service, Bookserv> bookservCollection;
    public static volatile SingularAttribute<Service, String> servicename;
    public static volatile SingularAttribute<Service, Integer> serviceid;

}