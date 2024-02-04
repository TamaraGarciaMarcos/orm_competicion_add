package DAO;
/**
 * Esta clase se encarga de simular la implementacion del DAO en la clase Equipo * 
 * @author Tamara Garcia Marcos
 */
import java.util.List;

import org.apache.logging.log4j.Logger;

import Modelo.Equipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EquipoDAO implements DAO<Equipo> {
	
	private Logger log;
    private EntityManagerFactory emf;
    private EntityManager em;

    public EquipoDAO() {
        // Nombre de la unidad de persistencia en el archivo persistence.xml
        emf = Persistence.createEntityManagerFactory("jpamysql");
        em = emf.createEntityManager();
    }

    @Override
    public void insert(Equipo equipo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.persist(equipo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            log.error("No se ha podido guardar el equipo en la base de datos");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
    }

    @Override
    public void update(Equipo equipo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.merge(equipo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            log.error("No se ha podido actualizar el equipo en la base de datos");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
    }

    @Override
    public void delete(Equipo equipo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            em.remove(em.contains(equipo) ? equipo : em.merge(equipo));
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            log.error("No se ha podido eliminar el equipo en la base de datos");
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
    public List<Equipo> getAll() {
        TypedQuery<Equipo> query = em.createQuery("SELECT e FROM Equip e", Equipo.class);
        return query.getResultList();
    }
}
