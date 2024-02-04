package DAO;
/**
 * Esta interfaz corresponde al patrón DAO que se va a implementar
 * 
 * @author Tamara Garcia Marcos
 */
import java.util.List;

public interface DAO<T> {
	public void insert( T entity);
	public void update(T entity);
	public void delete(T entity);
	public void cerrarRecursos();
	public List<T> getAll();
}
