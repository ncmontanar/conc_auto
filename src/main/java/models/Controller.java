/*
*quand models a besoin de travailler avec DAO,  à partir de la controller (models) va appller la PersistenceController (dao) 
*(et donc) pour pouvoir utiliser les methodes de la PC, la Controller (models) a besoin (des) d'une intasnce(s) de la  PErsistanceController   
 */
package models;

import DAO.PersistenceController;
import java.util.ArrayList;
import java.util.List;


public class Controller {
    
    PersistenceController controlPersis = new PersistenceController();
    
    
    //on va creer un client -1 qu'appelle à la persistence
    public void creerCustomer(String customerName, String contactLastName, String contactFirstName, String phone, String addressLine1, String addressLine2, String city, String state, String postalCode, String country, int creditLimit){
    
        //Customer cust = new Customer(customerNumber, customerName,contactLastName, contactFirstName,phone,addressLine1,addressLine2, city, state, postalCode, country, creditLimit,  salesRepEmployeeNumber,ordersList, paymentsList); // Employee salesRepEmployeeNumber, List<Order> ordersList, List<Payment> paymentsList
        // celuici vient de doGet de SvCustomer

        Customer cust = new Customer();                 // Employee salesRepEmployeeNumber, List<Order> ordersList, List<Payment> paymentsList
        cust.setCustomerNumber(0);
        cust.setCustomerName(customerName);
        cust.setContactLastName(contactLastName);
        cust.setContactFirstName(contactFirstName);
        cust.setPhone(phone);
        cust.setAddressLine1(addressLine1);
        cust.setAddressLine2(addressLine2);
        cust.setCity(city);
        cust.setState(state);
        cust.setPostalCode(postalCode);
        cust.setCountry(country);
        cust.setCreditLimit(0); 

        //       
        controlPersis.creerCustomer(cust);
        
    }

    //on va creer un produit -1 qu'appelle à la persistence

    public void creerProduit(String productName, String productScale, String productVendor, String productDescription, String quantityInStock, float buyPrice, float MSRP){
    
    Product prodt = new Product();
    prodt.setProductCode(0);
    prodt.setProductName(productName);
    prodt.setProductScale(productScale);
    prodt.setProductVendor(productVendor);
    prodt.setProductDescription(productDescription);
    prodt.setQuantityInStock(quantityInStock);
    prodt.setBuyPrice(buyPrice);
    prodt.setMSRP(MSRP);
    
   controlPersis.creerProduit(prodt);
    }       

    // celuici vient de doPost de SvCustomer
    public List <Customer> getCustomers() {
        return controlPersis.getCustomers();
    }
    
// 2eme pas : celuici vient de doPost de SvSuppCustomer

    public void effacerCustomer(int customerNumber) {
        controlPersis.effacerCustomer(customerNumber);

    }
    // 2eme pas : celuici vient de doGet de SvEditCustomer (pour editCustomer)
    public Customer emenerCustomer(int customerNumber) {
          return controlPersis.emenerCustomer(customerNumber);
    }
    
    // 2eme pas : celuici vient de doPost de SvEditCustomer
    public void editerCustomer(Customer cust) {
        controlPersis.editerCustomer(cust);
    }


    
}
