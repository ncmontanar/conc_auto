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

    public void creerCustomer(String customerName, String contactLastName, String contactFirstName, String phone, String addressLine1, String addressLine2, String city, String state, String postalCode, String country, float creditLimit, int salesRepEmployeeNumber) {    

        //Customer cust = new Customer(customerNumber, customerName,contactLastName, contactFirstName,phone,addressLine1,addressLine2, city, state, postalCode, country, creditLimit,  salesRepEmployeeNumber,ordersList, paymentsList); // Employee salesRepEmployeeNumber, List<Order> ordersList, List<Payment> paymentsList
        // celuici vient de doGet de SvCustomer

        Customer cust = new Customer();                 
        //cust.setCustomerNumber(0);
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
        cust.setCreditLimit(creditLimit);
        //cust.setSalesRepEmployeeNumber(salesRepEmployeeNumber);

        //       
        controlPersis.creerCustomer(cust);

    }
        
    //2.2 on va creer un produit -1 qu'appelle à la persistence
    public void creerProduit(String productName, String productLine, String productScale, String productVendor, String productDescription, String quantityInStock, float buyPrice, float MSRP){
        
        // celuici vient de doGet de SvProduct
        Product prodt = new Product();
        //prodt.setProductCode(0);
        prodt.setProductName(productName);
        //prodt.setProductLine(productLine);
        prodt.setProductScale(productScale);
        prodt.setProductVendor(productVendor);
        prodt.setProductDescription(productDescription);
        prodt.setQuantityInStock(quantityInStock);
        prodt.setBuyPrice(buyPrice);
        prodt.setMSRP(MSRP);

       controlPersis.creerProduit(prodt);
    }       



    // celuici vient de doGet de SvCustomer pour l'affichage
    public List <Customer> getCustomers() {
        return controlPersis.getCustomers();
    }
    // celuici vient de doGet de SvProduct pour l'affichage
    public List<Product> getProducts() {
        return controlPersis.getProducts();
    }    
    //4.4 creation du mtd qui va appeler la persistence
    public List<Office> getOffices() {
        return controlPersis.getOffices();
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
    
    //2eme pas : infos qui viennent du SvLogin/doPost  ---1. trer el usuario y contrasena; 2. buscar el ususario en cuestion en la bdd 3. encontrar si existe 4. verificar si la contrasena es correcta
    public boolean valideraccess(String email, String extension) {
        
        boolean ingressOk = false;
        
        List <Employee> listEmployeesAcss = new ArrayList<Employee>(); 
        listEmployeesAcss = controlPersis.getEmployees();
        
        for(Employee emp : listEmployeesAcss){
            if(emp.getEmail().equals(email)){                               // email changé de EmailLog __ vienent du doPost du SvLogin
                if(emp.getExtension().equals(extension)){                   // extension changé de PasswordLog __ vienent du doPost du SvLogin
                    ingressOk = true;
                }
                else{
                    ingressOk = false;
                }
                    
            }
        }       
        return ingressOk;

    }
    
    // 3.2 celuici vient de doPost de SvSuppProduit
    public void effacerProduct(int productCode) {
        controlPersis.effacerProduct(productCode);
    }

    /// 3.2 celuici vient de doGet de SvEditProduit (pour editProduit)
    public Product emenerProduit(int productCode) {
        return controlPersis.emenerProduit(productCode);
    }
    
    ///3.3  celuici vient de doPost de SvEditProduit

    public void editerProduit(Product pdrt) {
        controlPersis.editerProduit(pdrt);
    }    

        // Off_3.1 creation mtd  creerOffice et appelle à la bdd_persistence
    public void creerOffice(String officeCodeCh, String cityCh, String phoneCh, String addressLine1Ch, String addressLine2Ch, String stateCh, String countryCh, String postalCodeCh, String territoryCh) {
        Office offic = new Office();
        offic.setOfficeCode(officeCodeCh);
        offic.setCity(cityCh);
        offic.setPhone(phoneCh);
        offic.setAddressLine1(addressLine1Ch);
        offic.setAddressLine2(addressLine2Ch);
        offic.setState(stateCh);
        offic.setCountry(countryCh);
        offic.setPostalCode(postalCodeCh);
        offic.setTerritory(territoryCh);
        
        controlPersis.creerOffice(offic);
    }
        
    
    //Off_4.9 : creation dans la controller de mtd effacerOffice - celuici vient de doPost de SvSuppOffice
    public void effacerOffice(String officeCode) {
        controlPersis.effacerOffice(officeCode);
    }

    ///Off 4.12 creation dans la controler de mtd  emenerOffice - celuici vient de doGet du SvEditOffice
    public Office emenerOffice(String officeCode) {
        return controlPersis.emenerOffice(officeCode);
    }

    /// Off_4.20 creation mthd editerOffice qui va faire appel à la persistence _celuici vient de doPost du SvEditOffice
    public void editerOffice(Office offic) {
        controlPersis.editerOffice(offic);
    }
    

    
}
