package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Customer;
import models.Employee;
import models.Office;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-18T22:18:54")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, String> lastName;
    public static volatile SingularAttribute<Employee, String> firstName;
    public static volatile SingularAttribute<Employee, String> extension;
    public static volatile ListAttribute<Employee, Employee> employeeList;
    public static volatile SingularAttribute<Employee, String> jobTitle;
    public static volatile SingularAttribute<Employee, Office> officeCode;
    public static volatile SingularAttribute<Employee, Employee> reportsTo;
    public static volatile ListAttribute<Employee, Customer> customerListEmp;
    public static volatile SingularAttribute<Employee, String> email;
    public static volatile SingularAttribute<Employee, Integer> employeeNumber;

}