/*
 * 04/09/2023
 * Employee :
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Employee implements Serializable{ 
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String jobTitle; 
    
    //Employee to Employe Nto1
    @ManyToOne
    @JoinColumn(name = "reportsTo", referencedColumnName = "employeeNumber")
    private Employee reportsTo; 
    
    //Employee to Employe 1toN
    @OneToMany(mappedBy = "reportsTo")   
    private List<Employee> employeeList;
    
    //employees to customers 1toN//
    @OneToMany(mappedBy = "salesRepEmployeeNumber")
    private List<Customer> customerListEmp;

    //employees to offices Nto1
    @ManyToOne
    @JoinColumn(name = "officeCode", referencedColumnName = "officeCode")
    private Office officeCode; 
    
 
//const
   public Employee() {
    }

    public Employee(int employeeNumber, String lastName, String firstName, String extension, String email, String jobTitle, Employee reportsTo, List<Employee> employeeList, List<Customer> customerListEmp, Office officeCode) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.jobTitle = jobTitle;
        this.reportsTo = reportsTo;
        this.employeeList = employeeList;
        this.customerListEmp = customerListEmp;
        this.officeCode = officeCode;
    }
    

//get-set

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Employee getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Employee reportsTo) {
        this.reportsTo = reportsTo;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Customer> getCustomerListEmp() {
        return customerListEmp;
    }

    public void setCustomerListEmp(List<Customer> customerListEmp) {
        this.customerListEmp = customerListEmp;
    }

    public Office getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(Office officeCode) {
        this.officeCode = officeCode;
    }

}
