/*
 * 
 */

package DAO;

import DAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import models.Employee;
import models.Order;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Customer;
import models.Payment;



public class CustomerJpaController implements Serializable {

    public CustomerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    /// il faut creer le constructeur de JPA controller = il faut creer la emf EntityManagerFactory :
    //quand on a besoin des methodes CRUD de Customer -> il va creer une instance pour pouvoir utiliser cu de ces elements
    public CustomerJpaController() {
       emf = Persistence.createEntityManagerFactory("concessionnaire_mananger_PU") ;
    }


    public void create(Customer customer) {
        if (customer.getOrdersList() == null) {
            customer.setOrdersList(new ArrayList<Order>());
        }
        if (customer.getPaymentsList() == null) {
            customer.setPaymentsList(new ArrayList<Payment>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Employee salesRepEmployeeNumber = customer.getSalesRepEmployeeNumber();
            if (salesRepEmployeeNumber != null) {
                salesRepEmployeeNumber = em.getReference(salesRepEmployeeNumber.getClass(), salesRepEmployeeNumber.getEmployeeNumber());
                customer.setSalesRepEmployeeNumber(salesRepEmployeeNumber);
            }
            List<Order> attachedOrdersList = new ArrayList<Order>();
            for (Order ordersListOrderToAttach : customer.getOrdersList()) {
                ordersListOrderToAttach = em.getReference(ordersListOrderToAttach.getClass(), ordersListOrderToAttach.getOrderNumber());
                attachedOrdersList.add(ordersListOrderToAttach);
            }
            customer.setOrdersList(attachedOrdersList);
            List<Payment> attachedPaymentsList = new ArrayList<Payment>();
            for (Payment paymentsListPaymentToAttach : customer.getPaymentsList()) {
                paymentsListPaymentToAttach = em.getReference(paymentsListPaymentToAttach.getClass(), paymentsListPaymentToAttach.getPaymentcp());
                attachedPaymentsList.add(paymentsListPaymentToAttach);
            }
            customer.setPaymentsList(attachedPaymentsList);
            em.persist(customer);
            if (salesRepEmployeeNumber != null) {
                salesRepEmployeeNumber.getCustomerListEmp().add(customer);
                salesRepEmployeeNumber = em.merge(salesRepEmployeeNumber);
            }
            for (Order ordersListOrder : customer.getOrdersList()) {
                Customer oldCustomerNumberOfOrdersListOrder = ordersListOrder.getCustomerNumber();
                ordersListOrder.setCustomerNumber(customer);
                ordersListOrder = em.merge(ordersListOrder);
                if (oldCustomerNumberOfOrdersListOrder != null) {
                    oldCustomerNumberOfOrdersListOrder.getOrdersList().remove(ordersListOrder);
                    oldCustomerNumberOfOrdersListOrder = em.merge(oldCustomerNumberOfOrdersListOrder);
                }
            }
            for (Payment paymentsListPayment : customer.getPaymentsList()) {
                Customer oldCustomersOfPaymentsListPayment = paymentsListPayment.getCustomers();
                paymentsListPayment.setCustomers(customer);
                paymentsListPayment = em.merge(paymentsListPayment);
                if (oldCustomersOfPaymentsListPayment != null) {
                    oldCustomersOfPaymentsListPayment.getPaymentsList().remove(paymentsListPayment);
                    oldCustomersOfPaymentsListPayment = em.merge(oldCustomersOfPaymentsListPayment);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Customer customer) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Customer persistentCustomer = em.find(Customer.class, customer.getCustomerNumber());
            Employee salesRepEmployeeNumberOld = persistentCustomer.getSalesRepEmployeeNumber();
            Employee salesRepEmployeeNumberNew = customer.getSalesRepEmployeeNumber();
            List<Order> ordersListOld = persistentCustomer.getOrdersList();
            List<Order> ordersListNew = customer.getOrdersList();
            List<Payment> paymentsListOld = persistentCustomer.getPaymentsList();
            List<Payment> paymentsListNew = customer.getPaymentsList();
            if (salesRepEmployeeNumberNew != null) {
                salesRepEmployeeNumberNew = em.getReference(salesRepEmployeeNumberNew.getClass(), salesRepEmployeeNumberNew.getEmployeeNumber());
                customer.setSalesRepEmployeeNumber(salesRepEmployeeNumberNew);
            }
            List<Order> attachedOrdersListNew = new ArrayList<Order>();
            for (Order ordersListNewOrderToAttach : ordersListNew) {
                ordersListNewOrderToAttach = em.getReference(ordersListNewOrderToAttach.getClass(), ordersListNewOrderToAttach.getOrderNumber());
                attachedOrdersListNew.add(ordersListNewOrderToAttach);
            }
            ordersListNew = attachedOrdersListNew;
            customer.setOrdersList(ordersListNew);
            List<Payment> attachedPaymentsListNew = new ArrayList<Payment>();
            for (Payment paymentsListNewPaymentToAttach : paymentsListNew) {
                paymentsListNewPaymentToAttach = em.getReference(paymentsListNewPaymentToAttach.getClass(), paymentsListNewPaymentToAttach.getPaymentcp());
                attachedPaymentsListNew.add(paymentsListNewPaymentToAttach);
            }
            paymentsListNew = attachedPaymentsListNew;
            customer.setPaymentsList(paymentsListNew);
            customer = em.merge(customer);
            if (salesRepEmployeeNumberOld != null && !salesRepEmployeeNumberOld.equals(salesRepEmployeeNumberNew)) {
                salesRepEmployeeNumberOld.getCustomerListEmp().remove(customer);
                salesRepEmployeeNumberOld = em.merge(salesRepEmployeeNumberOld);
            }
            if (salesRepEmployeeNumberNew != null && !salesRepEmployeeNumberNew.equals(salesRepEmployeeNumberOld)) {
                salesRepEmployeeNumberNew.getCustomerListEmp().add(customer);
                salesRepEmployeeNumberNew = em.merge(salesRepEmployeeNumberNew);
            }
            for (Order ordersListOldOrder : ordersListOld) {
                if (!ordersListNew.contains(ordersListOldOrder)) {
                    ordersListOldOrder.setCustomerNumber(null);
                    ordersListOldOrder = em.merge(ordersListOldOrder);
                }
            }
            for (Order ordersListNewOrder : ordersListNew) {
                if (!ordersListOld.contains(ordersListNewOrder)) {
                    Customer oldCustomerNumberOfOrdersListNewOrder = ordersListNewOrder.getCustomerNumber();
                    ordersListNewOrder.setCustomerNumber(customer);
                    ordersListNewOrder = em.merge(ordersListNewOrder);
                    if (oldCustomerNumberOfOrdersListNewOrder != null && !oldCustomerNumberOfOrdersListNewOrder.equals(customer)) {
                        oldCustomerNumberOfOrdersListNewOrder.getOrdersList().remove(ordersListNewOrder);
                        oldCustomerNumberOfOrdersListNewOrder = em.merge(oldCustomerNumberOfOrdersListNewOrder);
                    }
                }
            }
            for (Payment paymentsListOldPayment : paymentsListOld) {
                if (!paymentsListNew.contains(paymentsListOldPayment)) {
                    paymentsListOldPayment.setCustomers(null);
                    paymentsListOldPayment = em.merge(paymentsListOldPayment);
                }
            }
            for (Payment paymentsListNewPayment : paymentsListNew) {
                if (!paymentsListOld.contains(paymentsListNewPayment)) {
                    Customer oldCustomersOfPaymentsListNewPayment = paymentsListNewPayment.getCustomers();
                    paymentsListNewPayment.setCustomers(customer);
                    paymentsListNewPayment = em.merge(paymentsListNewPayment);
                    if (oldCustomersOfPaymentsListNewPayment != null && !oldCustomersOfPaymentsListNewPayment.equals(customer)) {
                        oldCustomersOfPaymentsListNewPayment.getPaymentsList().remove(paymentsListNewPayment);
                        oldCustomersOfPaymentsListNewPayment = em.merge(oldCustomersOfPaymentsListNewPayment);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = customer.getCustomerNumber();
                if (findCustomer(id) == null) {
                    throw new NonexistentEntityException("The customer with id " + id + " no longer exists.");
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
            Customer customer;
            try {
                customer = em.getReference(Customer.class, id);
                customer.getCustomerNumber();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The customer with id " + id + " no longer exists.", enfe);
            }
            Employee salesRepEmployeeNumber = customer.getSalesRepEmployeeNumber();
            if (salesRepEmployeeNumber != null) {
                salesRepEmployeeNumber.getCustomerListEmp().remove(customer);
                salesRepEmployeeNumber = em.merge(salesRepEmployeeNumber);
            }
            List<Order> ordersList = customer.getOrdersList();
            for (Order ordersListOrder : ordersList) {
                ordersListOrder.setCustomerNumber(null);
                ordersListOrder = em.merge(ordersListOrder);
            }
            List<Payment> paymentsList = customer.getPaymentsList();
            for (Payment paymentsListPayment : paymentsList) {
                paymentsListPayment.setCustomers(null);
                paymentsListPayment = em.merge(paymentsListPayment);
            }
            em.remove(customer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Customer> findCustomerEntities() {
        return findCustomerEntities(true, -1, -1);
    }

    public List<Customer> findCustomerEntities(int maxResults, int firstResult) {
        return findCustomerEntities(false, maxResults, firstResult);
    }

    private List<Customer> findCustomerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Customer.class));
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

    public Customer findCustomer(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Customer.class, id);
        } finally {
            em.close();
        }
    }

    public int getCustomerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Customer> rt = cq.from(Customer.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
