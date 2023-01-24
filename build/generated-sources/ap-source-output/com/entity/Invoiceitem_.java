package com.entity;

import com.entity.Invoice;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-01-21T19:20:55", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Invoiceitem.class)
public class Invoiceitem_ { 

    public static volatile SingularAttribute<Invoiceitem, Integer> inId;
    public static volatile SingularAttribute<Invoiceitem, String> item;
    public static volatile CollectionAttribute<Invoiceitem, Invoice> invoiceCollection;
    public static volatile SingularAttribute<Invoiceitem, Integer> quantity;
    public static volatile SingularAttribute<Invoiceitem, Double> cost;

}