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
import models.Customer;
import models.OrderDetail;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Order;

/**
 *
 * @author CamiloM
 */
public class OrderJpaController implements Serializable {

    public OrderJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    //
    public OrderJpaController() {
    emf = Persistence.createEntityManagerFactory("concessionnaire_mananger_PU") ;
    }
    
    public void create(Order order) {
        if (order.getOrderDetailList() == null) {
            order.setOrderDetailList(new ArrayList<OrderDetail>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Customer customerNumber = order.getCustomerNumber();
            if (customerNumber != null) {
                customerNumber = em.getReference(customerNumber.getClass(), customerNumber.getCustomerNumber());
                order.setCustomerNumber(customerNumber);
            }
            List<OrderDetail> attachedOrderDetailList = new ArrayList<OrderDetail>();
            for (OrderDetail orderDetailListOrderDetailToAttach : order.getOrderDetailList()) {
                orderDetailListOrderDetailToAttach = em.getReference(orderDetailListOrderDetailToAttach.getClass(), orderDetailListOrderDetailToAttach.getOrderdetailcp());
                attachedOrderDetailList.add(orderDetailListOrderDetailToAttach);
            }
            order.setOrderDetailList(attachedOrderDetailList);
            em.persist(order);
            if (customerNumber != null) {
                customerNumber.getOrdersList().add(order);
                customerNumber = em.merge(customerNumber);
            }
            for (OrderDetail orderDetailListOrderDetail : order.getOrderDetailList()) {
                Order oldOrdersOfOrderDetailListOrderDetail = orderDetailListOrderDetail.getOrders();
                orderDetailListOrderDetail.setOrders(order);
                orderDetailListOrderDetail = em.merge(orderDetailListOrderDetail);
                if (oldOrdersOfOrderDetailListOrderDetail != null) {
                    oldOrdersOfOrderDetailListOrderDetail.getOrderDetailList().remove(orderDetailListOrderDetail);
                    oldOrdersOfOrderDetailListOrderDetail = em.merge(oldOrdersOfOrderDetailListOrderDetail);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Order order) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Order persistentOrder = em.find(Order.class, order.getOrderNumber());
            Customer customerNumberOld = persistentOrder.getCustomerNumber();
            Customer customerNumberNew = order.getCustomerNumber();
            List<OrderDetail> orderDetailListOld = persistentOrder.getOrderDetailList();
            List<OrderDetail> orderDetailListNew = order.getOrderDetailList();
            if (customerNumberNew != null) {
                customerNumberNew = em.getReference(customerNumberNew.getClass(), customerNumberNew.getCustomerNumber());
                order.setCustomerNumber(customerNumberNew);
            }
            List<OrderDetail> attachedOrderDetailListNew = new ArrayList<OrderDetail>();
            for (OrderDetail orderDetailListNewOrderDetailToAttach : orderDetailListNew) {
                orderDetailListNewOrderDetailToAttach = em.getReference(orderDetailListNewOrderDetailToAttach.getClass(), orderDetailListNewOrderDetailToAttach.getOrderdetailcp());
                attachedOrderDetailListNew.add(orderDetailListNewOrderDetailToAttach);
            }
            orderDetailListNew = attachedOrderDetailListNew;
            order.setOrderDetailList(orderDetailListNew);
            order = em.merge(order);
            if (customerNumberOld != null && !customerNumberOld.equals(customerNumberNew)) {
                customerNumberOld.getOrdersList().remove(order);
                customerNumberOld = em.merge(customerNumberOld);
            }
            if (customerNumberNew != null && !customerNumberNew.equals(customerNumberOld)) {
                customerNumberNew.getOrdersList().add(order);
                customerNumberNew = em.merge(customerNumberNew);
            }
            for (OrderDetail orderDetailListOldOrderDetail : orderDetailListOld) {
                if (!orderDetailListNew.contains(orderDetailListOldOrderDetail)) {
                    orderDetailListOldOrderDetail.setOrders(null);
                    orderDetailListOldOrderDetail = em.merge(orderDetailListOldOrderDetail);
                }
            }
            for (OrderDetail orderDetailListNewOrderDetail : orderDetailListNew) {
                if (!orderDetailListOld.contains(orderDetailListNewOrderDetail)) {
                    Order oldOrdersOfOrderDetailListNewOrderDetail = orderDetailListNewOrderDetail.getOrders();
                    orderDetailListNewOrderDetail.setOrders(order);
                    orderDetailListNewOrderDetail = em.merge(orderDetailListNewOrderDetail);
                    if (oldOrdersOfOrderDetailListNewOrderDetail != null && !oldOrdersOfOrderDetailListNewOrderDetail.equals(order)) {
                        oldOrdersOfOrderDetailListNewOrderDetail.getOrderDetailList().remove(orderDetailListNewOrderDetail);
                        oldOrdersOfOrderDetailListNewOrderDetail = em.merge(oldOrdersOfOrderDetailListNewOrderDetail);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = order.getOrderNumber();
                if (findOrder(id) == null) {
                    throw new NonexistentEntityException("The order with id " + id + " no longer exists.");
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
            Order order;
            try {
                order = em.getReference(Order.class, id);
                order.getOrderNumber();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The order with id " + id + " no longer exists.", enfe);
            }
            Customer customerNumber = order.getCustomerNumber();
            if (customerNumber != null) {
                customerNumber.getOrdersList().remove(order);
                customerNumber = em.merge(customerNumber);
            }
            List<OrderDetail> orderDetailList = order.getOrderDetailList();
            for (OrderDetail orderDetailListOrderDetail : orderDetailList) {
                orderDetailListOrderDetail.setOrders(null);
                orderDetailListOrderDetail = em.merge(orderDetailListOrderDetail);
            }
            em.remove(order);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Order> findOrderEntities() {
        return findOrderEntities(true, -1, -1);
    }

    public List<Order> findOrderEntities(int maxResults, int firstResult) {
        return findOrderEntities(false, maxResults, firstResult);
    }

    private List<Order> findOrderEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Order.class));
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

    public Order findOrder(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Order.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrderCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Order> rt = cq.from(Order.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
