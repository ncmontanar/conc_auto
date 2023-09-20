package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Customer;
import models.PaymentCP;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-18T22:18:54")
@StaticMetamodel(Payment.class)
public class Payment_ { 

    public static volatile SingularAttribute<Payment, Float> amount;
    public static volatile SingularAttribute<Payment, PaymentCP> paymentcp;
    public static volatile SingularAttribute<Payment, Customer> customers;
    public static volatile SingularAttribute<Payment, Date> paymentDate;

}