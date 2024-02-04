package DAO;

import java.util.List;

import org.apache.logging.log4j.Logger;

import Modelo.Entrenador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EntrenadorDAO implements DAO<Entrenador> {

	private Logger log;
    private EntityManagerFactory emf;
    private EntityManager em;

    public EntrenadorDAO() {
        // Nombre de la unidad de persistencia en el archivo persistence.xml
        emf = Persistence.createEntityManagerFactory("jpamysql");
        em = emf.createEntityManager();
    }

    @Override
    public void insert(Entrenador entrenador) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.persist(entrenador);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            log.error("No se ha podido guardar el entrenador en la base de datos");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
    }

    @Override
    public void update(Entrenador entrenador) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.merge(entrenador);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            log.error("No se ha podido actualizar el entrenador en la base de datos");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
    }

    @Override
    public void delete(Entrenador entrenador) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.remove(em.contains(entrenador) ? entrenador : em.merge(entrenador));
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            log.error("No se ha podido eliminar el entrenador en la base de datos");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
    }

    @Override
    public List<Entrenador> getAll() {
        TypedQuery<Entrenador> query = em.createQuery("SELECT e FROM Entrenador e", Entrenador.class);
        return query.getResultList();
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

	
}