/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Negocio.Profesor;
import java.io.Serializable;

/**
 *
 * @author Frank
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Persistence;

public class ProfesorJpaController implements Serializable {

  private EntityManagerFactory emf = null;

    public ProfesorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
  public ProfesorJpaController() {
        emf = Persistence.createEntityManagerFactory("plataformaPU");  
    }
    
    
    
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Crear un nuevo profesor
    public void create(Profesor profesor) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(profesor);
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

    // Editar un profesor existente
    public void edit(Profesor profesor) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            profesor = em.merge(profesor);
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

    // Eliminar un profesor
    public void destroy(Integer id) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Profesor profesor = em.getReference(Profesor.class, id);
            em.remove(profesor);
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

    // Encontrar un profesor por ID
    public Profesor findProfesor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Profesor.class, id);
        } finally {
            em.close();
        }
    }

    // Obtener todos los profesores
    public List<Profesor> findProfesorEntities() {
        return findProfesorEntities(true, -1, -1);
    }

    // Obtener un rango de profesores
    public List<Profesor> findProfesorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT p FROM Profesor p");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    // Contar el número total de profesores
    public int getProfesorCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT COUNT(p) FROM Profesor p");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}