/*
*06/09/2023
* Payment
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Payment implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PaymentCP paymentcp;
    
    
    @Temporal(TemporalType.DATE)
    private Date  paymentDate;
    private float amount; 
    
    //(103) customer to payments Nto1 !!!
    @ManyToOne
    @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber")
    private Customer customers;

    
    //const

    public Payment() {
    }

    /// constructeur avec CLé Principale (103)
    public Payment(PaymentCP paymentcp) {
        this.paymentcp = paymentcp;
    }
    
    
    /// constructeur sans detaille de clés principales 
    public Payment(PaymentCP paymentcp, Date paymentDate, float amount, Customer customers) {
        this.paymentcp = paymentcp;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    /// (103)constructeur avec detaille de clés principales_1 
    public Payment(PaymentCP paymentcp, Date paymentDate, float amount) {
        this.paymentcp = paymentcp;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }
    
        /// (103)constructeur avec detaille de clés principales_2 ???
        public Payment(int customerNumber, String checkNumber) {
            this.paymentcp = new PaymentCP(customerNumber,checkNumber);
    }
    
    
    
///

    public PaymentCP getPaymentcp() {
        return paymentcp;
    }

    public void setPaymentcp(PaymentCP paymentcp) {
        this.paymentcp = paymentcp;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }


   
    
    
}
