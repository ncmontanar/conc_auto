/*
 * C
 */
package models;

import javax.persistence.Embeddable;



@Embeddable
public class orderDetailCP {
    
    private int orderNumber; 
    private int productCode; 

    public orderDetailCP() {
    }

    public orderDetailCP(int orderNumber, int productCode) {
        this.orderNumber = orderNumber;
        this.productCode = productCode;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }
    
    
    
    
}
