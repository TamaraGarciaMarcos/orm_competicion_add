package DAO;

import java.util.List;

import org.apache.logging.log4j.Logger;

import Modelo.Patrocinador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class PatrocinadorDAO implements DAO<Patrocinador> {
	private Logger log;
    private EntityManagerFactory emf;
    private EntityManager em;

    public PatrocinadorDAO() {
        // Nombre de la unidad de persistencia en el archivo persistence.xml
        emf = Persistence.createEntityManagerFactory("jpamysql");
        em = emf.createEntityManager();
    }

    @Override
    public void insert(Patrocinador patrocinador) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.persist(patrocinador);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            log.error("No se ha podido guardar el patrocinador en la base de datos");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
    }

    @Override
    public void update(Patrocinador patrocinador) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.merge(patrocinador);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            log.error("No se ha podido modificar el patrocinador en la base de datos");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
    }

    @Override
    public void delete(Patrocinador patrocinador) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.remove(em.contains(patrocinador) ? patrocinador : em.merge(patrocinador));
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            log.error("No se ha podido eliminar el patrocinador en la base de datos");
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
    public List<Patrocinador> getAll() {
        TypedQuery<Patrocinador> query = em.createQuery("SELECT p FROM Patrocinador p", Patrocinador.class);
        return query.getResultList();
    }

    // Métodos adicionales según sea necesario

    public void closeEntityManager() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }

    public void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
