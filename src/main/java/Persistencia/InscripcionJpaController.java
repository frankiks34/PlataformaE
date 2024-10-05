/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Negocio.Inscripcion;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class InscripcionJpaController implements Serializable {

   private EntityManagerFactory emf = null;

    public InscripcionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

      public InscripcionJpaController() {
        emf = Persistence.createEntityManagerFactory("plataformaPU");  
    }
    
    
    
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Crear una nueva inscripción
    public void create(Inscripcion inscripcion) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(inscripcion);
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

    // Editar una inscripción existente
    public void edit(Inscripcion inscripcion) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            inscripcion = em.merge(inscripcion);
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

    // Eliminar una inscripción
    public void destroy(Integer id) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Inscripcion inscripcion = em.getReference(Inscripcion.class, id);
            em.remove(inscripcion);
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

    // Encontrar una inscripción por ID
    public Inscripcion findInscripcion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Inscripcion.class, id);
        } finally {
            em.close();
        }
    }

    // Obtener todas las inscripciones
    public List<Inscripcion> findInscripcionEntities() {
        return findInscripcionEntities(true, -1, -1);
    }

    // Obtener un rango de inscripciones
    public List<Inscripcion> findInscripcionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT i FROM Inscripcion i");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    // Contar el número total de inscripciones
    public int getInscripcionCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT COUNT(i) FROM Inscripcion i");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
