package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Customer;
import models.OrderDetail;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-24T16:01:42")
@StaticMetamodel(Order.class)
public class Order_ { 

    public static volatile ListAttribute<Order, OrderDetail> orderDetailList;
    public static volatile SingularAttribute<Order, Integer> orderNumber;
    public static volatile SingularAttribute<Order, String> comments;
    public static volatile SingularAttribute<Order, Date> requiredDate;
    public static volatile SingularAttribute<Order, Customer> customerNumber;
    public static volatile SingularAttribute<Order, Date> orderDate;
    public static volatile SingularAttribute<Order, Date> shippedDate;
    public static volatile SingularAttribute<Order, String> status;

}