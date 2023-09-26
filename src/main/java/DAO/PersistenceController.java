/*
*reçoit ce que la DAO le sollicite, la PC va jusqua la BD et fait l'operation 
*ou si la DAO le demande, elle va lire la bdd, et à travers la m^me PC va repondre au DAO  
* -> il faut creer une instance de chaque un de chacun des JpaControllers : ici on va mettre tous les methodes CRUD
 */
package DAO;


import DAO.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Customer;
import models.Product;


public class PersistenceController {
    
    CustomerJpaController customrJPA = new CustomerJpaController();
    
//    EmployeeJpaController emplyeJPA = new EmployeeJpaController();
    
//    OfficeJpaController offcJPA = new OfficeJpaController();
    
//    OrderJpaController ordeJPA = new OrderJpaController();
    
//    OrderDetailJpaController orddetlJPA = new OrderDetailJpaController();
    
//    PaymentJpaController paiemJPA = new PaymentJpaController();
    
    ProductJpaController pdtoJPA = new ProductJpaController();
    
//    ProductLineJpaController pdtolinJPA = new ProductLineJpaController();

    
    //3eme pas : vient de controller : on va creer un client -2.1
    public void creerCustomer(Customer cust) {
        customrJPA.create(cust);
    }
    
    
    //on va creer un Produit -2.3
    public void creerProduit(Product prodt){
        pdtoJPA.create(prodt);
    }

    // vient de controller :  public ArrayList <Customer> getCustomers
    public List<Customer> getCustomers() {
        return customrJPA.findCustomerEntities();
    }

    // 3eme pas : vient de controller :  public void effacerCustomer(int customerNumber

    public void effacerCustomer(int customerNumber){ 
        try {
            customrJPA.destroy(customerNumber);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // 3eme pas : vient de controller :  public void effacerCustomer(int customerNumber
    
    public Customer emenerCustomer(int customerNumber) {
        return customrJPA.findCustomer(customerNumber);
    }

    
        // 3eme pas : vient de controller :  public void editerCustomer(Customer cust) {
    public void editerCustomer(Customer cust) {
        try {
            customrJPA.edit(cust);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    
}