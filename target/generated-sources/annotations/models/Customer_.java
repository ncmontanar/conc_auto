package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Employee;
import models.Order;
import models.Payment;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-10-30T22:00:52")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> country;
    public static volatile ListAttribute<Customer, Payment> paymentsList;
    public static volatile SingularAttribute<Customer, String> city;
    public static volatile SingularAttribute<Customer, String> contactFirstName;
    public static volatile SingularAttribute<Customer, String> postalCode;
    public static volatile SingularAttribute<Customer, Employee> salesRepEmployeeNumber;
    public static volatile SingularAttribute<Customer, Integer> customerNumber;
    public static volatile SingularAttribute<Customer, String> customerName;
    public static volatile SingularAttribute<Customer, String> phone;
    public static volatile SingularAttribute<Customer, String> addressLine1;
    public static volatile SingularAttribute<Customer, Float> creditLimit;
    public static volatile SingularAttribute<Customer, String> contactLastName;
    public static volatile SingularAttribute<Customer, String> addressLine2;
    public static volatile SingularAttribute<Customer, String> state;
    public static volatile ListAttribute<Customer, Order> ordersList;

}