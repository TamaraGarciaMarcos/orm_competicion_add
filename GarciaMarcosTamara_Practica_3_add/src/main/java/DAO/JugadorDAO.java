package DAO;
/**
 * Esta clase se encarga de simular la implementacion del DAO en la clase Jugador * 
 * @author Tamara Garcia Marcos
 */
import java.util.List;

import org.apache.logging.log4j.Logger;

import Modelo.Jugador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class JugadorDAO implements DAO<Jugador> {
	private Logger log;
    private EntityManagerFactory emf;
    private EntityManager em;

    public JugadorDAO() {
        // Nombre de la unidad de persistencia en el archivo persistence.xml
        emf = Persistence.createEntityManagerFactory("jpamysql");
        em = emf.createEntityManager();
    }

    @Override
    public void insert(Jugador jugador) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.persist(jugador);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            log.error("No se ha podido guardar el jugador en la base de datos");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
    }

    @Override
    public void update(Jugador jugador) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.merge(jugador);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            log.error("No se ha podido actualizar el jugador en la base de datos");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
    }

    @Override
    public void delete(Jugador jugador) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.remove(em.contains(jugador) ? jugador : em.merge(jugador));
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            log.error("No se ha podido eliminar el jugador en la base de datos");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
    }

    @Override
    public List<Jugador> getAll() {
        TypedQuery<Jugador> query = em.createQuery("SELECT j FROM Player j", Jugador.class);
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
