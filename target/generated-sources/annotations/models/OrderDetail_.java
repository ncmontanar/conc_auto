package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Order;
import models.Product;
import models.orderDetailCP;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-18T22:18:54")
@StaticMetamodel(OrderDetail.class)
public class OrderDetail_ { 

    public static volatile SingularAttribute<OrderDetail, orderDetailCP> orderdetailcp;
    public static volatile SingularAttribute<OrderDetail, Integer> quantityOrdered;
    public static volatile SingularAttribute<OrderDetail, Order> orders;
    public static volatile SingularAttribute<OrderDetail, Integer> orderLineNumber;
    public static volatile SingularAttribute<OrderDetail, Float> priceEach;
    public static volatile SingularAttribute<OrderDetail, Product> products;

}