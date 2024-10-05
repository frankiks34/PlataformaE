/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Negocio.Reseña;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Persistence;

public class ReseñaJpaController implements Serializable {

   private EntityManagerFactory emf = null;

    public ReseñaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

      public ReseñaJpaController() {
        emf = Persistence.createEntityManagerFactory("plataformaPU");  
    }
    
    
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    
    

    // Crear una nueva reseña
    public void create(Reseña reseña) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(reseña);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    // Editar una reseña existente
    public void edit(Reseña reseña) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            reseña = em.merge(reseña);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    // Eliminar una reseña
    public void destroy(Integer id) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Reseña reseña = em.getReference(Reseña.class, id);
            em.remove(reseña);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    // Encontrar una reseña por ID
    public Reseña findReseña(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reseña.class, id);
        } finally {
            em.close();
        }
    }

    // Obtener todas las reseñas
    public List<Reseña> findReseñaEntities() {
        return findReseñaEntities(true, -1, -1);
    }

    // Obtener un rango de reseñas
    public List<Reseña> findReseñaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT r FROM Reseña r");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    // Contar el número total de reseñas
    public int getReseñaCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT COUNT(r) FROM Reseña r");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}

