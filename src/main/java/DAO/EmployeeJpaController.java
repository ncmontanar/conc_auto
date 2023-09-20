/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import models.Employee;
import models.Office;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Customer;

/**
 *
 * @author CamiloM
 */
public class EmployeeJpaController implements Serializable {

    public EmployeeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //
    public EmployeeJpaController() {
    emf = Persistence.createEntityManagerFactory("concessionnaire_mananger_PU") ;
    }

    public void create(Employee employee) {
        if (employee.getEmployeeList() == null) {
            employee.setEmployeeList(new ArrayList<Employee>());
        }
        if (employee.getCustomerListEmp() == null) {
            employee.setCustomerListEmp(new ArrayList<Customer>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Employee reportsTo = employee.getReportsTo();
            if (reportsTo != null) {
                reportsTo = em.getReference(reportsTo.getClass(), reportsTo.getEmployeeNumber());
                employee.setReportsTo(reportsTo);
            }
            Office officeCode = employee.getOfficeCode();
            if (officeCode != null) {
                officeCode = em.getReference(officeCode.getClass(), officeCode.getOfficeCode());
                employee.setOfficeCode(officeCode);
            }
            List<Employee> attachedEmployeeList = new ArrayList<Employee>();
            for (Employee employeeListEmployeeToAttach : employee.getEmployeeList()) {
                employeeListEmployeeToAttach = em.getReference(employeeListEmployeeToAttach.getClass(), employeeListEmployeeToAttach.getEmployeeNumber());
                attachedEmployeeList.add(employeeListEmployeeToAttach);
            }
            employee.setEmployeeList(attachedEmployeeList);
            List<Customer> attachedCustomerListEmp = new ArrayList<Customer>();
            for (Customer customerListEmpCustomerToAttach : employee.getCustomerListEmp()) {
                customerListEmpCustomerToAttach = em.getReference(customerListEmpCustomerToAttach.getClass(), customerListEmpCustomerToAttach.getCustomerNumber());
                attachedCustomerListEmp.add(customerListEmpCustomerToAttach);
            }
            employee.setCustomerListEmp(attachedCustomerListEmp);
            em.persist(employee);
            if (reportsTo != null) {
                Employee oldReportsToOfReportsTo = reportsTo.getReportsTo();
                if (oldReportsToOfReportsTo != null) {
                    oldReportsToOfReportsTo.setReportsTo(null);
                    oldReportsToOfReportsTo = em.merge(oldReportsToOfReportsTo);
                }
                reportsTo.setReportsTo(employee);
                reportsTo = em.merge(reportsTo);
            }
            if (officeCode != null) {
                officeCode.getOfficeEmployesList().add(employee);
                officeCode = em.merge(officeCode);
            }
            for (Employee employeeListEmployee : employee.getEmployeeList()) {
                Employee oldReportsToOfEmployeeListEmployee = employeeListEmployee.getReportsTo();
                employeeListEmployee.setReportsTo(employee);
                employeeListEmployee = em.merge(employeeListEmployee);
                if (oldReportsToOfEmployeeListEmployee != null) {
                    oldReportsToOfEmployeeListEmployee.getEmployeeList().remove(employeeListEmployee);
                    oldReportsToOfEmployeeListEmployee = em.merge(oldReportsToOfEmployeeListEmployee);
                }
            }
            for (Customer customerListEmpCustomer : employee.getCustomerListEmp()) {
                Employee oldSalesRepEmployeeNumberOfCustomerListEmpCustomer = customerListEmpCustomer.getSalesRepEmployeeNumber();
                customerListEmpCustomer.setSalesRepEmployeeNumber(employee);
                customerListEmpCustomer = em.merge(customerListEmpCustomer);
                if (oldSalesRepEmployeeNumberOfCustomerListEmpCustomer != null) {
                    oldSalesRepEmployeeNumberOfCustomerListEmpCustomer.getCustomerListEmp().remove(customerListEmpCustomer);
                    oldSalesRepEmployeeNumberOfCustomerListEmpCustomer = em.merge(oldSalesRepEmployeeNumberOfCustomerListEmpCustomer);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Employee employee) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Employee persistentEmployee = em.find(Employee.class, employee.getEmployeeNumber());
            Employee reportsToOld = persistentEmployee.getReportsTo();
            Employee reportsToNew = employee.getReportsTo();
            Office officeCodeOld = persistentEmployee.getOfficeCode();
            Office officeCodeNew = employee.getOfficeCode();
            List<Employee> employeeListOld = persistentEmployee.getEmployeeList();
            List<Employee> employeeListNew = employee.getEmployeeList();
            List<Customer> customerListEmpOld = persistentEmployee.getCustomerListEmp();
            List<Customer> customerListEmpNew = employee.getCustomerListEmp();
            if (reportsToNew != null) {
                reportsToNew = em.getReference(reportsToNew.getClass(), reportsToNew.getEmployeeNumber());
                employee.setReportsTo(reportsToNew);
            }
            if (officeCodeNew != null) {
                officeCodeNew = em.getReference(officeCodeNew.getClass(), officeCodeNew.getOfficeCode());
                employee.setOfficeCode(officeCodeNew);
            }
            List<Employee> attachedEmployeeListNew = new ArrayList<Employee>();
            for (Employee employeeListNewEmployeeToAttach : employeeListNew) {
                employeeListNewEmployeeToAttach = em.getReference(employeeListNewEmployeeToAttach.getClass(), employeeListNewEmployeeToAttach.getEmployeeNumber());
                attachedEmployeeListNew.add(employeeListNewEmployeeToAttach);
            }
            employeeListNew = attachedEmployeeListNew;
            employee.setEmployeeList(employeeListNew);
            List<Customer> attachedCustomerListEmpNew = new ArrayList<Customer>();
            for (Customer customerListEmpNewCustomerToAttach : customerListEmpNew) {
                customerListEmpNewCustomerToAttach = em.getReference(customerListEmpNewCustomerToAttach.getClass(), customerListEmpNewCustomerToAttach.getCustomerNumber());
                attachedCustomerListEmpNew.add(customerListEmpNewCustomerToAttach);
            }
            customerListEmpNew = attachedCustomerListEmpNew;
            employee.setCustomerListEmp(customerListEmpNew);
            employee = em.merge(employee);
            if (reportsToOld != null && !reportsToOld.equals(reportsToNew)) {
                reportsToOld.setReportsTo(null);
                reportsToOld = em.merge(reportsToOld);
            }
            if (reportsToNew != null && !reportsToNew.equals(reportsToOld)) {
                Employee oldReportsToOfReportsTo = reportsToNew.getReportsTo();
                if (oldReportsToOfReportsTo != null) {
                    oldReportsToOfReportsTo.setReportsTo(null);
                    oldReportsToOfReportsTo = em.merge(oldReportsToOfReportsTo);
                }
                reportsToNew.setReportsTo(employee);
                reportsToNew = em.merge(reportsToNew);
            }
            if (officeCodeOld != null && !officeCodeOld.equals(officeCodeNew)) {
                officeCodeOld.getOfficeEmployesList().remove(employee);
                officeCodeOld = em.merge(officeCodeOld);
            }
            if (officeCodeNew != null && !officeCodeNew.equals(officeCodeOld)) {
                officeCodeNew.getOfficeEmployesList().add(employee);
                officeCodeNew = em.merge(officeCodeNew);
            }
            for (Employee employeeListOldEmployee : employeeListOld) {
                if (!employeeListNew.contains(employeeListOldEmployee)) {
                    employeeListOldEmployee.setReportsTo(null);
                    employeeListOldEmployee = em.merge(employeeListOldEmployee);
                }
            }
            for (Employee employeeListNewEmployee : employeeListNew) {
                if (!employeeListOld.contains(employeeListNewEmployee)) {
                    Employee oldReportsToOfEmployeeListNewEmployee = employeeListNewEmployee.getReportsTo();
                    employeeListNewEmployee.setReportsTo(employee);
                    employeeListNewEmployee = em.merge(employeeListNewEmployee);
                    if (oldReportsToOfEmployeeListNewEmployee != null && !oldReportsToOfEmployeeListNewEmployee.equals(employee)) {
                        oldReportsToOfEmployeeListNewEmployee.getEmployeeList().remove(employeeListNewEmployee);
                        oldReportsToOfEmployeeListNewEmployee = em.merge(oldReportsToOfEmployeeListNewEmployee);
                    }
                }
            }
            for (Customer customerListEmpOldCustomer : customerListEmpOld) {
                if (!customerListEmpNew.contains(customerListEmpOldCustomer)) {
                    customerListEmpOldCustomer.setSalesRepEmployeeNumber(null);
                    customerListEmpOldCustomer = em.merge(customerListEmpOldCustomer);
                }
            }
            for (Customer customerListEmpNewCustomer : customerListEmpNew) {
                if (!customerListEmpOld.contains(customerListEmpNewCustomer)) {
                    Employee oldSalesRepEmployeeNumberOfCustomerListEmpNewCustomer = customerListEmpNewCustomer.getSalesRepEmployeeNumber();
                    customerListEmpNewCustomer.setSalesRepEmployeeNumber(employee);
                    customerListEmpNewCustomer = em.merge(customerListEmpNewCustomer);
                    if (oldSalesRepEmployeeNumberOfCustomerListEmpNewCustomer != null && !oldSalesRepEmployeeNumberOfCustomerListEmpNewCustomer.equals(employee)) {
                        oldSalesRepEmployeeNumberOfCustomerListEmpNewCustomer.getCustomerListEmp().remove(customerListEmpNewCustomer);
                        oldSalesRepEmployeeNumberOfCustomerListEmpNewCustomer = em.merge(oldSalesRepEmployeeNumberOfCustomerListEmpNewCustomer);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = employee.getEmployeeNumber();
                if (findEmployee(id) == null) {
                    throw new NonexistentEntityException("The employee with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Employee employee;
            try {
                employee = em.getReference(Employee.class, id);
                employee.getEmployeeNumber();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The employee with id " + id + " no longer exists.", enfe);
            }
            Employee reportsTo = employee.getReportsTo();
            if (reportsTo != null) {
                reportsTo.setReportsTo(null);
                reportsTo = em.merge(reportsTo);
            }
            Office officeCode = employee.getOfficeCode();
            if (officeCode != null) {
                officeCode.getOfficeEmployesList().remove(employee);
                officeCode = em.merge(officeCode);
            }
            List<Employee> employeeList = employee.getEmployeeList();
            for (Employee employeeListEmployee : employeeList) {
                employeeListEmployee.setReportsTo(null);
                employeeListEmployee = em.merge(employeeListEmployee);
            }
            List<Customer> customerListEmp = employee.getCustomerListEmp();
            for (Customer customerListEmpCustomer : customerListEmp) {
                customerListEmpCustomer.setSalesRepEmployeeNumber(null);
                customerListEmpCustomer = em.merge(customerListEmpCustomer);
            }
            em.remove(employee);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Employee> findEmployeeEntities() {
        return findEmployeeEntities(true, -1, -1);
    }

    public List<Employee> findEmployeeEntities(int maxResults, int firstResult) {
        return findEmployeeEntities(false, maxResults, firstResult);
    }

    private List<Employee> findEmployeeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Employee.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Employee findEmployee(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Employee.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmployeeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Employee> rt = cq.from(Employee.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
