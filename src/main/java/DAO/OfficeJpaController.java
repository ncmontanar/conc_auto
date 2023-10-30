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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Office;

/**
 *
 * @author CamiloM
 */
public class OfficeJpaController implements Serializable {

    public OfficeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

        //
    public OfficeJpaController() {
    emf = Persistence.createEntityManagerFactory("concessionnaire_mananger_PU") ;
    }
    
    public void create(Office office) {
        if (office.getOfficeEmployesList() == null) {
            office.setOfficeEmployesList(new ArrayList<Employee>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Employee> attachedOfficeEmployesList = new ArrayList<Employee>();
            for (Employee officeEmployesListEmployeeToAttach : office.getOfficeEmployesList()) {
                officeEmployesListEmployeeToAttach = em.getReference(officeEmployesListEmployeeToAttach.getClass(), officeEmployesListEmployeeToAttach.getEmployeeNumber());
                attachedOfficeEmployesList.add(officeEmployesListEmployeeToAttach);
            }
            office.setOfficeEmployesList(attachedOfficeEmployesList);
            em.persist(office);
            for (Employee officeEmployesListEmployee : office.getOfficeEmployesList()) {
                Office oldOfficeCodeOfOfficeEmployesListEmployee = officeEmployesListEmployee.getOfficeCode();
                officeEmployesListEmployee.setOfficeCode(office);
                officeEmployesListEmployee = em.merge(officeEmployesListEmployee);
                if (oldOfficeCodeOfOfficeEmployesListEmployee != null) {
                    oldOfficeCodeOfOfficeEmployesListEmployee.getOfficeEmployesList().remove(officeEmployesListEmployee);
                    oldOfficeCodeOfOfficeEmployesListEmployee = em.merge(oldOfficeCodeOfOfficeEmployesListEmployee);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Office office) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Office persistentOffice = em.find(Office.class, office.getOfficeCode());
            List<Employee> officeEmployesListOld = persistentOffice.getOfficeEmployesList();
            List<Employee> officeEmployesListNew = office.getOfficeEmployesList();
            List<Employee> attachedOfficeEmployesListNew = new ArrayList<Employee>();
            for (Employee officeEmployesListNewEmployeeToAttach : officeEmployesListNew) {
                officeEmployesListNewEmployeeToAttach = em.getReference(officeEmployesListNewEmployeeToAttach.getClass(), officeEmployesListNewEmployeeToAttach.getEmployeeNumber());
                attachedOfficeEmployesListNew.add(officeEmployesListNewEmployeeToAttach);
            }
            officeEmployesListNew = attachedOfficeEmployesListNew;
            office.setOfficeEmployesList(officeEmployesListNew);
            office = em.merge(office);
            for (Employee officeEmployesListOldEmployee : officeEmployesListOld) {
                if (!officeEmployesListNew.contains(officeEmployesListOldEmployee)) {
                    officeEmployesListOldEmployee.setOfficeCode(null);
                    officeEmployesListOldEmployee = em.merge(officeEmployesListOldEmployee);
                }
            }
            for (Employee officeEmployesListNewEmployee : officeEmployesListNew) {
                if (!officeEmployesListOld.contains(officeEmployesListNewEmployee)) {
                    Office oldOfficeCodeOfOfficeEmployesListNewEmployee = officeEmployesListNewEmployee.getOfficeCode();
                    officeEmployesListNewEmployee.setOfficeCode(office);
                    officeEmployesListNewEmployee = em.merge(officeEmployesListNewEmployee);
                    if (oldOfficeCodeOfOfficeEmployesListNewEmployee != null && !oldOfficeCodeOfOfficeEmployesListNewEmployee.equals(office)) {
                        oldOfficeCodeOfOfficeEmployesListNewEmployee.getOfficeEmployesList().remove(officeEmployesListNewEmployee);
                        oldOfficeCodeOfOfficeEmployesListNewEmployee = em.merge(oldOfficeCodeOfOfficeEmployesListNewEmployee);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = office.getOfficeCode();
                if (findOffice(id) == null) {
                    throw new NonexistentEntityException("The office with id " + id + " no longer exists.");
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
            Office office;
            try {
                office = em.getReference(Office.class, id);
                office.getOfficeCode();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The office with id " + id + " no longer exists.", enfe);
            }
            List<Employee> officeEmployesList = office.getOfficeEmployesList();
            for (Employee officeEmployesListEmployee : officeEmployesList) {
                officeEmployesListEmployee.setOfficeCode(null);
                officeEmployesListEmployee = em.merge(officeEmployesListEmployee);
            }
            em.remove(office);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Office> findOfficeEntities() {
        return findOfficeEntities(true, -1, -1);
    }

    public List<Office> findOfficeEntities(int maxResults, int firstResult) {
        return findOfficeEntities(false, maxResults, firstResult);
    }

    private List<Office> findOfficeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Office.class));
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

    public Office findOffice(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Office.class, id);
        } finally {
            em.close();
        }
    }

    public int getOfficeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Office> rt = cq.from(Office.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
