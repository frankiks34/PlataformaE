package Persistencia;

import Negocio.bolsa_Compras; // Asegúrate de tener esta clase definida
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Persistence;

public class bolsa_ComprasJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public bolsa_ComprasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public bolsa_ComprasJpaController() {
        emf = Persistence.createEntityManagerFactory("plataformaPU");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Crear una nueva bolsa de compras
    public void create(bolsa_Compras bolsaCompras) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(bolsaCompras);
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

    // Editar una bolsa de compras existente
    public void edit(bolsa_Compras bolsaCompras) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            bolsaCompras = em.merge(bolsaCompras);
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

    // Eliminar una bolsa de compras
    public void destroy(Integer id) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            bolsa_Compras bolsaCompras = em.getReference(bolsa_Compras.class, id);
            em.remove(bolsaCompras);
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

    // Encontrar una bolsa de compras por ID
    public bolsa_Compras findBolsaCompras(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(bolsa_Compras.class, id);
        } finally {
            em.close();
        }
    }

    // Obtener todas las bolsas de compras
    public List<bolsa_Compras> findBolsaComprasEntities() {
        return findBolsaComprasEntities(true, -1, -1);
    }

    // Obtener un rango de bolsas de compras
    public List<bolsa_Compras> findBolsaComprasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT b FROM bolsa_Compras b");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    // Contar el número total de bolsas de compras
    public int getBolsaComprasCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT COUNT(b) FROM bolsa_Compras b");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}