package com.entity;

import com.entity.Servemp;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-01-21T19:20:55", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, Integer> empid;
    public static volatile SingularAttribute<Employee, String> firstname;
    public static volatile SingularAttribute<Employee, String> gender;
    public static volatile SingularAttribute<Employee, String> passwd;
    public static volatile SingularAttribute<Employee, String> dob;
    public static volatile CollectionAttribute<Employee, Servemp> servempCollection;
    public static volatile SingularAttribute<Employee, Integer> phonenumber;
    public static volatile SingularAttribute<Employee, String> email;
    public static volatile SingularAttribute<Employee, String> lastname;
    public static volatile SingularAttribute<Employee, String> username;

}