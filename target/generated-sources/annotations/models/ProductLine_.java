package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Product;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-24T16:01:42")
@StaticMetamodel(ProductLine.class)
public class ProductLine_ { 

    public static volatile SingularAttribute<ProductLine, String> productLine;
    public static volatile SingularAttribute<ProductLine, String> image;
    public static volatile ListAttribute<ProductLine, Product> productsList;
    public static volatile SingularAttribute<ProductLine, String> textDescription;
    public static volatile SingularAttribute<ProductLine, String> htmlDescription;

}