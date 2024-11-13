package Persistencia;

import Negocio.Boleta;  // Importar la clase de entidad Boleta
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Frank
 */
public class BoletaJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public BoletaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public BoletaJpaController() {
        emf = Persistence.createEntityManagerFactory("plataformaPU");  // Cambia 'plataformaPU' según tu configuración de persistence.xml
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Crear una nueva boleta
    public void create(Boleta boleta) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(boleta);  // Persiste la nueva boleta en la base de datos
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();  // Si hay error, deshacer la transacción
            }
            throw e;
        } finally {
            em.close();
        }
    }

    // Editar una boleta existente
    public void edit(Boleta boleta) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            boleta = em.merge(boleta);  // Realiza el merge (actualiza la boleta)
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

    // Eliminar una boleta por ID
    public void destroy(Integer id) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Boleta boleta = em.getReference(Boleta.class, id);  // Obtiene la boleta por ID
            em.remove(boleta);  // Elimina la boleta
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

    // Encontrar una boleta por ID
    public Boleta findBoleta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Boleta.class, id);  // Busca la boleta por ID
        } finally {
            em.close();
        }
    }

    // Obtener todas las boletas
    public List<Boleta> findBoletaEntities() {
        return findBoletaEntities(true, -1, -1);
    }

    // Obtener un rango de boletas (por ejemplo, por paginación)
    public List<Boleta> findBoletaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT b FROM Boleta b");  // Consulta a la base de datos para obtener las boletas
            if (!all) {
                q.setMaxResults(maxResults);  // Configura el número máximo de resultados
                q.setFirstResult(firstResult);  // Configura el primer resultado (para paginación)
            }
            return q.getResultList();  // Devuelve la lista de boletas
        } finally {
            em.close();
        }
    }

    // Contar el número total de boletas
    public int getBoletaCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT COUNT(b) FROM Boleta b");  // Contar el total de boletas
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}