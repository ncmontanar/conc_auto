/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import models.ProductLine;
import models.OrderDetail;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import models.Product;




public class ProductJpaController implements Serializable {

    public ProductJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

        //
    public ProductJpaController() {
    emf = Persistence.createEntityManagerFactory("concessionnaire_mananger_PU") ;
    }
    
    public void create(Product product) {
        if (product.getOrderDetailList() == null) {
            product.setOrderDetailList(new ArrayList<OrderDetail>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProductLine productLine = product.getProductLine();
            if (productLine != null) {
                productLine = em.getReference(productLine.getClass(), productLine.getProductLine());
                product.setProductLine(productLine);
            }
            List<OrderDetail> attachedOrderDetailList = new ArrayList<OrderDetail>();
            for (OrderDetail orderDetailListOrderDetailToAttach : product.getOrderDetailList()) {
                orderDetailListOrderDetailToAttach = em.getReference(orderDetailListOrderDetailToAttach.getClass(), orderDetailListOrderDetailToAttach.getOrderdetailcp());
                attachedOrderDetailList.add(orderDetailListOrderDetailToAttach);
            }
            product.setOrderDetailList(attachedOrderDetailList);
            em.persist(product);
            if (productLine != null) {
                productLine.getProductsList().add(product);
                productLine = em.merge(productLine);
            }
            for (OrderDetail orderDetailListOrderDetail : product.getOrderDetailList()) {
                Product oldProductsOfOrderDetailListOrderDetail = orderDetailListOrderDetail.getProducts();
                orderDetailListOrderDetail.setProducts(product);
                orderDetailListOrderDetail = em.merge(orderDetailListOrderDetail);
                if (oldProductsOfOrderDetailListOrderDetail != null) {
                    oldProductsOfOrderDetailListOrderDetail.getOrderDetailList().remove(orderDetailListOrderDetail);
                    oldProductsOfOrderDetailListOrderDetail = em.merge(oldProductsOfOrderDetailListOrderDetail);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Product product) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Product persistentProduct = em.find(Product.class, product.getProductCode());
            ProductLine productLineOld = persistentProduct.getProductLine();
            ProductLine productLineNew = product.getProductLine();
            List<OrderDetail> orderDetailListOld = persistentProduct.getOrderDetailList();
            List<OrderDetail> orderDetailListNew = product.getOrderDetailList();
            if (productLineNew != null) {
                productLineNew = em.getReference(productLineNew.getClass(), productLineNew.getProductLine());
                product.setProductLine(productLineNew);
            }
            List<OrderDetail> attachedOrderDetailListNew = new ArrayList<OrderDetail>();
            for (OrderDetail orderDetailListNewOrderDetailToAttach : orderDetailListNew) {
                orderDetailListNewOrderDetailToAttach = em.getReference(orderDetailListNewOrderDetailToAttach.getClass(), orderDetailListNewOrderDetailToAttach.getOrderdetailcp());
                attachedOrderDetailListNew.add(orderDetailListNewOrderDetailToAttach);
            }
            orderDetailListNew = attachedOrderDetailListNew;
            product.setOrderDetailList(orderDetailListNew);
            product = em.merge(product);
            if (productLineOld != null && !productLineOld.equals(productLineNew)) {
                productLineOld.getProductsList().remove(product);
                productLineOld = em.merge(productLineOld);
            }
            if (productLineNew != null && !productLineNew.equals(productLineOld)) {
                productLineNew.getProductsList().add(product);
                productLineNew = em.merge(productLineNew);
            }
            for (OrderDetail orderDetailListOldOrderDetail : orderDetailListOld) {
                if (!orderDetailListNew.contains(orderDetailListOldOrderDetail)) {
                    orderDetailListOldOrderDetail.setProducts(null);
                    orderDetailListOldOrderDetail = em.merge(orderDetailListOldOrderDetail);
                }
            }
            for (OrderDetail orderDetailListNewOrderDetail : orderDetailListNew) {
                if (!orderDetailListOld.contains(orderDetailListNewOrderDetail)) {
                    Product oldProductsOfOrderDetailListNewOrderDetail = orderDetailListNewOrderDetail.getProducts();
                    orderDetailListNewOrderDetail.setProducts(product);
                    orderDetailListNewOrderDetail = em.merge(orderDetailListNewOrderDetail);
                    if (oldProductsOfOrderDetailListNewOrderDetail != null && !oldProductsOfOrderDetailListNewOrderDetail.equals(product)) {
                        oldProductsOfOrderDetailListNewOrderDetail.getOrderDetailList().remove(orderDetailListNewOrderDetail);
                        oldProductsOfOrderDetailListNewOrderDetail = em.merge(oldProductsOfOrderDetailListNewOrderDetail);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = product.getProductCode();
                if (findProduct(id) == null) {
                    throw new NonexistentEntityException("The product with id " + id + " no longer exists.");
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
            Product product;
            try {
                product = em.getReference(Product.class, id);
                product.getProductCode();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The product with id " + id + " no longer exists.", enfe);
            }
            ProductLine productLine = product.getProductLine();
            if (productLine != null) {
                productLine.getProductsList().remove(product);
                productLine = em.merge(productLine);
            }
            List<OrderDetail> orderDetailList = product.getOrderDetailList();
            for (OrderDetail orderDetailListOrderDetail : orderDetailList) {
                orderDetailListOrderDetail.setProducts(null);
                orderDetailListOrderDetail = em.merge(orderDetailListOrderDetail);
            }
            em.remove(product);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Product> findProductEntities() {
        return findProductEntities(true, -1, -1);
    }

    public List<Product> findProductEntities(int maxResults, int firstResult) {
        return findProductEntities(false, maxResults, firstResult);
    }

    private List<Product> findProductEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Product.class));
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

    public Product findProduct(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Product.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Product> rt = cq.from(Product.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    ///
    public float getTotalMsrpSum() {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Float> cq = cb.createQuery(Float.class);
            Root<Product> root = cq.from(Product.class);
            cq.select(cb.sum(root.get("MSRP")));
            TypedQuery<Float> q = em.createQuery(cq);
            return q.getSingleResult();
        } finally {
            em.close();
        }
    }
    
    ///
    public float getTotalBuyPrice() {
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Float> cq = cb.createQuery(Float.class);
            Root<Product> root = cq.from(Product.class);
            cq.select(cb.sum(root.get("buyPrice")));
            TypedQuery<Float> query = em.createQuery(cq);
            Float result = query.getSingleResult();
            return result != null ? result.floatValue() : 0f;
        } finally {
            em.close();
    }
        
        
}

    
    

    
}
