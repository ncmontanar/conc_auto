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
import models.Product;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.ProductLine;

/**
 *
 * @author CamiloM
 */
public class ProductLineJpaController implements Serializable {

    public ProductLineJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //
    public ProductLineJpaController() {
    emf = Persistence.createEntityManagerFactory("concessionnaire_mananger_PU") ;
    }
    
    public void create(ProductLine productLine) {
        if (productLine.getProductsList() == null) {
            productLine.setProductsList(new ArrayList<Product>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Product> attachedProductsList = new ArrayList<Product>();
            for (Product productsListProductToAttach : productLine.getProductsList()) {
                productsListProductToAttach = em.getReference(productsListProductToAttach.getClass(), productsListProductToAttach.getProductCode());
                attachedProductsList.add(productsListProductToAttach);
            }
            productLine.setProductsList(attachedProductsList);
            em.persist(productLine);
            for (Product productsListProduct : productLine.getProductsList()) {
                ProductLine oldProductLineOfProductsListProduct = productsListProduct.getProductLine();
                productsListProduct.setProductLine(productLine);
                productsListProduct = em.merge(productsListProduct);
                if (oldProductLineOfProductsListProduct != null) {
                    oldProductLineOfProductsListProduct.getProductsList().remove(productsListProduct);
                    oldProductLineOfProductsListProduct = em.merge(oldProductLineOfProductsListProduct);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProductLine productLine) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProductLine persistentProductLine = em.find(ProductLine.class, productLine.getProductLine());
            List<Product> productsListOld = persistentProductLine.getProductsList();
            List<Product> productsListNew = productLine.getProductsList();
            List<Product> attachedProductsListNew = new ArrayList<Product>();
            for (Product productsListNewProductToAttach : productsListNew) {
                productsListNewProductToAttach = em.getReference(productsListNewProductToAttach.getClass(), productsListNewProductToAttach.getProductCode());
                attachedProductsListNew.add(productsListNewProductToAttach);
            }
            productsListNew = attachedProductsListNew;
            productLine.setProductsList(productsListNew);
            productLine = em.merge(productLine);
            for (Product productsListOldProduct : productsListOld) {
                if (!productsListNew.contains(productsListOldProduct)) {
                    productsListOldProduct.setProductLine(null);
                    productsListOldProduct = em.merge(productsListOldProduct);
                }
            }
            for (Product productsListNewProduct : productsListNew) {
                if (!productsListOld.contains(productsListNewProduct)) {
                    ProductLine oldProductLineOfProductsListNewProduct = productsListNewProduct.getProductLine();
                    productsListNewProduct.setProductLine(productLine);
                    productsListNewProduct = em.merge(productsListNewProduct);
                    if (oldProductLineOfProductsListNewProduct != null && !oldProductLineOfProductsListNewProduct.equals(productLine)) {
                        oldProductLineOfProductsListNewProduct.getProductsList().remove(productsListNewProduct);
                        oldProductLineOfProductsListNewProduct = em.merge(oldProductLineOfProductsListNewProduct);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = productLine.getProductLine();
                if (findProductLine(id) == null) {
                    throw new NonexistentEntityException("The productLine with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProductLine productLine;
            try {
                productLine = em.getReference(ProductLine.class, id);
                productLine.getProductLine();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productLine with id " + id + " no longer exists.", enfe);
            }
            List<Product> productsList = productLine.getProductsList();
            for (Product productsListProduct : productsList) {
                productsListProduct.setProductLine(null);
                productsListProduct = em.merge(productsListProduct);
            }
            em.remove(productLine);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProductLine> findProductLineEntities() {
        return findProductLineEntities(true, -1, -1);
    }

    public List<ProductLine> findProductLineEntities(int maxResults, int firstResult) {
        return findProductLineEntities(false, maxResults, firstResult);
    }

    private List<ProductLine> findProductLineEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProductLine.class));
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

    public ProductLine findProductLine(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProductLine.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductLineCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProductLine> rt = cq.from(ProductLine.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
