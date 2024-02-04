package DAO;
/**
 * Esta clase se encarga de simular la implementacion del DAO en la competicion

 * 
 * @author Tamara Garcia Marcos
 */
import java.util.List;

import org.apache.logging.log4j.Logger;

import Modelo.Competicion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class CompeticionDAO implements DAO<Competicion> {
	private Logger log;
    private EntityManagerFactory emf;
    private EntityManager em;

    public CompeticionDAO() {
        // Nombre de la unidad de persistencia en el archivo persistence.xml
        emf = Persistence.createEntityManagerFactory("jpamysql");
        em = emf.createEntityManager();
    }

    @Override
    public void insert(Competicion competicion) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.persist(competicion);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            log.error("No se ha podido guardar la competición en la base de datos");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
    }

    @Override
    public void update(Competicion competicion) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.merge(competicion);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            log.error("No se ha podido actualizar la competicion en la base de datos");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
    }

    @Override
    public void delete(Competicion competicion) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.remove(em.contains(competicion) ? competicion : em.merge(competicion));
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            log.error("No se ha podido eliminar la competicion en la base de datos");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
    }
    
    @Override
    public void cerrarRecursos() {
        if (em != null && em.isOpen()) {
            em.close();
        }

        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    @Override
    public List<Competicion> getAll() {
        TypedQuery<Competicion> query = em.createQuery("SELECT c FROM Competition c", Competicion.class);
        return query.getResultList();
    }
}
