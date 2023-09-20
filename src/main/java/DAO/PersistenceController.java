/*
*reçoit ce que la DAO le sollicite, la PC va jusqua la BD et fait l'operation 
*ou si la DAO le demande, elle va lire la bdd, et à travers la m^me PC va repondre au DAO  
* -> il faut creer une instance de chaque un de chacun des JpaControllers : ici on va mettre tous les methodes CRUD
 */
package DAO;

import models.Customer;


public class PersistenceController {
    
    CustomerJpaController customrJPA = new CustomerJpaController();
    
    EmployeeJpaController emplyeJPA = new EmployeeJpaController();
    
    OfficeJpaController offcJPA = new OfficeJpaController();
    
    OrderJpaController ordeJPA = new OrderJpaController();
    
    OrderDetailJpaController orddetlJPA = new OrderDetailJpaController();
    
    PaymentJpaController paiemJPA = new PaymentJpaController();
    
    ProductJpaController pdtoJPA = new ProductJpaController();
    
    ProductLineJpaController pdtolinJPA = new ProductLineJpaController();

    
    //on va creer un client -2
    public void creerCustomer(Customer cust) {
        customrJPA.create(cust);
    }
    
    
    
    
}
