package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Employee;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-10-25T16:35:30")
@StaticMetamodel(Office.class)
public class Office_ { 

    public static volatile SingularAttribute<Office, String> country;
    public static volatile SingularAttribute<Office, String> city;
    public static volatile SingularAttribute<Office, String> phone;
    public static volatile SingularAttribute<Office, String> postalCode;
    public static volatile SingularAttribute<Office, String> officeCode;
    public static volatile SingularAttribute<Office, String> addressLine1;
    public static volatile SingularAttribute<Office, String> addressLine2;
    public static volatile SingularAttribute<Office, String> state;
    public static volatile ListAttribute<Office, Employee> officeEmployesList;
    public static volatile SingularAttribute<Office, String> territory;

}