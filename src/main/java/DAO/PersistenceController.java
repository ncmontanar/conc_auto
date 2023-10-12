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
import models.Employee;
import models.Office;
import models.Product;


public class PersistenceController {
    
    CustomerJpaController customrJPA = new CustomerJpaController();
    
    EmployeeJpaController emplyeJPA = new EmployeeJpaController();
    
    OfficeJpaController offcJPA = new OfficeJpaController();
    
//    OrderJpaController ordeJPA = new OrderJpaController();
    
//    OrderDetailJpaController orddetlJPA = new OrderDetailJpaController();
    
//    PaymentJpaController paiemJPA = new PaymentJpaController();
    
    ProductJpaController pdtoJPA = new ProductJpaController();
    
//    ProductLineJpaController pdtolinJPA = new ProductLineJpaController();

    //**********STOCKS **********************************//
    
    //on va creer un Produit -2.3
    public void creerProduit(Product prodt){
        pdtoJPA.create(prodt);
    }     
    
        // pour appeler la bdd  pour l'affichage
    public List<Product> getProducts() {
        return pdtoJPA.findProductEntities();  
    }
    
    //3.3 : vient de controller  : public void effacerProduct(int productCode)

    public void effacerProduct(int productCode) {
        try {
            pdtoJPA.destroy(productCode);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // 3eme pas : vient de controller :  emenerProduit(int productCode)
    public Product emenerProduit(int productCode) {
        return pdtoJPA.findProduct(productCode);
    }
    
    
    ///3eme pas : vient de controller :  public void editerProduit(Product pdrt) {
    public void editerProduit(Product pdrt) {
        try {
            pdtoJPA.edit(pdrt);        
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    //**********AGENCES **********************************//
 
    //Off_3.2 creation de mtdo creerOffice
    public void creerOffice(Office offic) {
        offcJPA.create(offic);
    }
    
    //Off_4.5 vient de controller pour appeler la bdd 
    public List<Office> getOffices() {
      return offcJPA.findOfficeEntities();
    }

    //Off_4.10 creation de effacerOffice qui vient de controller : public void effacerOffice(String officeCode)
    public void effacerOffice(String officeCode) {
        try {
            offcJPA.destroy(officeCode);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Off_4.13 creation de emenerOffice qui vient de controller et sert à lister
    public Office emenerOffice(String officeCode) {
        return offcJPA.findOffice(officeCode);
    }
    
    ///Off_4.21   creation de mtd editerOffice qui va appeller la JPA
    public void editerOffice(Office offic) {
        try {
            offcJPA.edit(offic);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //********** Ressources Humaines **********************************//
    
    ///Empl_5.2.4 creerEmployee crée en JPA - ceci vient de controller creerEmployee

    public void creerEmployee(Employee employ) {
        emplyeJPA.create(employ); 
    }
    
    //vient de controller :  public boolean valideraccess(String email, String extension) FOR LOG ACCES
    public List<Employee> getEmployees() {
        return emplyeJPA.findEmployeeEntities();
    }
    
    /// 5.3.4 creation de la methode en persistence
    public List<Employee> getEmployeesAff() {
        return emplyeJPA.findEmployeeEntities();
    }

    // 5.4.3 creation du metode qui va appeller la JPA
    public void effacerEmployee(int employeeNumber) {
        try {
            emplyeJPA.destroy(employeeNumber);
            
        } catch (NonexistentEntityException ex) {
           Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // 5.6.3 creation de emenerEmployee (qui vient de controller) et va appler la JPA
    public Employee emenerEmployee(int employeeNumber) {
        return emplyeJPA.findEmployee(employeeNumber);
    }
    
    ///5.6.8  creer le mtd editerEmployee et faire appel à la JPA
    public void editerEmployee(Employee emply) {
        try {
            emplyeJPA.edit(emply);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    //********** CLIENTS **********************************//
   
    //3eme pas : vient de controller : on va creer un client -2.1
    public void creerCustomer(Customer cust) {
        customrJPA.create(cust);
    }
    
    // vient de controller :  public List <Customer> getCustomers
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