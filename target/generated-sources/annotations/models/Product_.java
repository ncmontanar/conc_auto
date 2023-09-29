package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.OrderDetail;
import models.ProductLine;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-28T16:03:58")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, String> quantityInStock;
    public static volatile SingularAttribute<Product, Float> buyPrice;
    public static volatile SingularAttribute<Product, Float> MSRP;
    public static volatile SingularAttribute<Product, ProductLine> productLine;
    public static volatile ListAttribute<Product, OrderDetail> orderDetailList;
    public static volatile SingularAttribute<Product, Integer> productCode;
    public static volatile SingularAttribute<Product, String> productScale;
    public static volatile SingularAttribute<Product, String> productName;
    public static volatile SingularAttribute<Product, String> productVendor;
    public static volatile SingularAttribute<Product, String> productDescription;

}