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
import models.Order;
import models.OrderDetail;
import models.Product;
import models.orderDetailCP;

/**
 *
 * @author CamiloM
 */
public class OrderDetailJpaController implements Serializable {

    public OrderDetailJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //
    public OrderDetailJpaController() {
    emf = Persistence.createEntityManagerFactory("concessionnaire_mananger_PU") ;
    }
    
    public void create(OrderDetail orderDetail) throws PreexistingEntityException, Exception {
        if (orderDetail.getOrderdetailcp() == null) {
            orderDetail.setOrderdetailcp(new orderDetailCP());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Order orders = orderDetail.getOrders();
            if (orders != null) {
                orders = em.getReference(orders.getClass(), orders.getOrderNumber());
                orderDetail.setOrders(orders);
            }
            Product products = orderDetail.getProducts();
            if (products != null) {
                products = em.getReference(products.getClass(), products.getProductCode());
                orderDetail.setProducts(products);
            }
            em.persist(orderDetail);
            if (orders != null) {
                orders.getOrderDetailList().add(orderDetail);
                orders = em.merge(orders);
            }
            if (products != null) {
                products.getOrderDetailList().add(orderDetail);
                products = em.merge(products);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrderDetail(orderDetail.getOrderdetailcp()) != null) {
                throw new PreexistingEntityException("OrderDetail " + orderDetail + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OrderDetail orderDetail) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OrderDetail persistentOrderDetail = em.find(OrderDetail.class, orderDetail.getOrderdetailcp());
            Order ordersOld = persistentOrderDetail.getOrders();
            Order ordersNew = orderDetail.getOrders();
            Product productsOld = persistentOrderDetail.getProducts();
            Product productsNew = orderDetail.getProducts();
            if (ordersNew != null) {
                ordersNew = em.getReference(ordersNew.getClass(), ordersNew.getOrderNumber());
                orderDetail.setOrders(ordersNew);
            }
            if (productsNew != null) {
                productsNew = em.getReference(productsNew.getClass(), productsNew.getProductCode());
                orderDetail.setProducts(productsNew);
            }
            orderDetail = em.merge(orderDetail);
            if (ordersOld != null && !ordersOld.equals(ordersNew)) {
                ordersOld.getOrderDetailList().remove(orderDetail);
                ordersOld = em.merge(ordersOld);
            }
            if (ordersNew != null && !ordersNew.equals(ordersOld)) {
                ordersNew.getOrderDetailList().add(orderDetail);
                ordersNew = em.merge(ordersNew);
            }
            if (productsOld != null && !productsOld.equals(productsNew)) {
                productsOld.getOrderDetailList().remove(orderDetail);
                productsOld = em.merge(productsOld);
            }
            if (productsNew != null && !productsNew.equals(productsOld)) {
                productsNew.getOrderDetailList().add(orderDetail);
                productsNew = em.merge(productsNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                orderDetailCP id = orderDetail.getOrderdetailcp();
                if (findOrderDetail(id) == null) {
                    throw new NonexistentEntityException("The orderDetail with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(orderDetailCP id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OrderDetail orderDetail;
            try {
                orderDetail = em.getReference(OrderDetail.class, id);
                orderDetail.getOrderdetailcp();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The orderDetail with id " + id + " no longer exists.", enfe);
            }
            Order orders = orderDetail.getOrders();
            if (orders != null) {
                orders.getOrderDetailList().remove(orderDetail);
                orders = em.merge(orders);
            }
            Product products = orderDetail.getProducts();
            if (products != null) {
                products.getOrderDetailList().remove(orderDetail);
                products = em.merge(products);
            }
            em.remove(orderDetail);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OrderDetail> findOrderDetailEntities() {
        return findOrderDetailEntities(true, -1, -1);
    }

    public List<OrderDetail> findOrderDetailEntities(int maxResults, int firstResult) {
        return findOrderDetailEntities(false, maxResults, firstResult);
    }

    private List<OrderDetail> findOrderDetailEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OrderDetail.class));
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

    public OrderDetail findOrderDetail(orderDetailCP id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OrderDetail.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrderDetailCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OrderDetail> rt = cq.from(OrderDetail.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
