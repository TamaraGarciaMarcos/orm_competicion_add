package Modelo;
/**
 * Esta clase se encarga de simular un patrocinador de la competicion

 * 
 * @author Tamara Garcia Marcos
 */
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Partner")
public class Patrocinador {
	@Id @GeneratedValue
	private int id;
	@Column(name="Name")
	private String nombre;
	@ManyToMany(mappedBy = "patrocinadores") // Relación ManyToMany con la clase Equipo
    private List<Equipo> equipos;
	
	//Constructor
	public Patrocinador(String nombre) {
		this.nombre= nombre;
	}
	
	public Patrocinador (int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Patrocinador [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
