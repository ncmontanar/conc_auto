/*
 * lier customer avec paiments
 * 
 */
package models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PaymentCP implements Serializable{
    
    
    private int customerNumber;
    @Column(length = 25)
    private String checkNumber ;

//
    public PaymentCP() {
    }
//

    public PaymentCP(int customerNumber, String checkNumber) {
        this.customerNumber = customerNumber;
        this.checkNumber = checkNumber;
    }
    
    
    
    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }
    
    
    
}
