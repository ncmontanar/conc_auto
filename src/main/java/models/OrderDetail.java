/*
 * 06/09/2023
 * OrderDetail :
 */
package models;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class OrderDetail implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected orderDetailCP orderdetailcp;


    private int quantityOrdered;
    private float priceEach;
    private int orderLineNumber;
    
    //(101) order to orderdetails Nto1  !!!
    @ManyToOne
    @JoinColumn(name = "orderNumber", referencedColumnName = "orderNumber")    
    private Order orders;
    
    //(102)order to products Nto1 !!!
    @ManyToOne
    @JoinColumn(name = "productCode", referencedColumnName = "productCode")
    private Product products;
    
       
    /*cons*/

   
    public OrderDetail() {
    }
    
    /// constructeur avec CLé Principale (101)

    public OrderDetail(orderDetailCP orderdetailcp) {
        this.orderdetailcp = orderdetailcp;
    }

    /// constructeur sans detaille de clés principales_1 
    public OrderDetail(orderDetailCP orderdetailcp, int quantityOrdered, float priceEach, int orderLineNumber) {
        this.orderdetailcp = orderdetailcp;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
        
    }

    /// (101)constructeur avec detaille de clés principales_2 ???
    public OrderDetail(int orderNumber, int productCode) {
        this.orderdetailcp = new orderDetailCP(orderNumber, productCode);
    }




    ///

    public orderDetailCP getOrderdetailcp() {
        return orderdetailcp;
    }

    public void setOrderdetailcp(orderDetailCP orderdetailcp) {
        this.orderdetailcp = orderdetailcp;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public float getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(float priceEach) {
        this.priceEach = priceEach;
    }

    public int getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(int orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    public Order getOrders() {
        return orders;
    }

    public void setOrders(Order orders) {
        this.orders = orders;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

   
    
}
