/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import models.Customer;
import models.Payment;
import models.PaymentCP;

/**
 *
 * @author CamiloM
 */
public class PaymentJpaController implements Serializable {

    public PaymentJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //
    public PaymentJpaController() {
    emf = Persistence.createEntityManagerFactory("concessionnaire_mananger_PU") ;
    }
    
    public void create(Payment payment) throws PreexistingEntityException, Exception {
        if (payment.getPaymentcp() == null) {
            payment.setPaymentcp(new PaymentCP());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Customer customers = payment.getCustomers();
            if (customers != null) {
                customers = em.getReference(customers.getClass(), customers.getCustomerNumber());
                payment.setCustomers(customers);
            }
            em.persist(payment);
            if (customers != null) {
                customers.getPaymentsList().add(payment);
                customers = em.merge(customers);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPayment(payment.getPaymentcp()) != null) {
                throw new PreexistingEntityException("Payment " + payment + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Payment payment) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Payment persistentPayment = em.find(Payment.class, payment.getPaymentcp());
            Customer customersOld = persistentPayment.getCustomers();
            Customer customersNew = payment.getCustomers();
            if (customersNew != null) {
                customersNew = em.getReference(customersNew.getClass(), customersNew.getCustomerNumber());
                payment.setCustomers(customersNew);
            }
            payment = em.merge(payment);
            if (customersOld != null && !customersOld.equals(customersNew)) {
                customersOld.getPaymentsList().remove(payment);
                customersOld = em.merge(customersOld);
            }
            if (customersNew != null && !customersNew.equals(customersOld)) {
                customersNew.getPaymentsList().add(payment);
                customersNew = em.merge(customersNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PaymentCP id = payment.getPaymentcp();
                if (findPayment(id) == null) {
                    throw new NonexistentEntityException("The payment with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PaymentCP id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Payment payment;
            try {
                payment = em.getReference(Payment.class, id);
                payment.getPaymentcp();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The payment with id " + id + " no longer exists.", enfe);
            }
            Customer customers = payment.getCustomers();
            if (customers != null) {
                customers.getPaymentsList().remove(payment);
                customers = em.merge(customers);
            }
            em.remove(payment);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Payment> findPaymentEntities() {
        return findPaymentEntities(true, -1, -1);
    }

    public List<Payment> findPaymentEntities(int maxResults, int firstResult) {
        return findPaymentEntities(false, maxResults, firstResult);
    }

    private List<Payment> findPaymentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Payment.class));
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

    public Payment findPayment(PaymentCP id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Payment.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaymentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Payment> rt = cq.from(Payment.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
