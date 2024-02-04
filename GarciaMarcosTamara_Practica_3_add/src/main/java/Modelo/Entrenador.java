package Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="coach")
public class Entrenador {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "Nickname")
	private String apodo;
	@Column(name = "Name")
	private String nombre;
	@Column(name = "Country")
	private String nacionalidad;
	@Column(name = "Birth")
	private String fechaNacimiento;
	
	@OneToOne
	private Equipo equipo;

	public Entrenador() {
		
	}
	
	public Entrenador(String apodo, String nombre, String nacionalidad, String fechaNacimiento) {
		this.apodo = apodo;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
		
	}
	
	public Entrenador(long id, String apodo, String nombre, String nacionalidad, String fechaNacimiento) {
		this.id = id;
		this.apodo = apodo;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
		
		}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Entrenador, apodo: " + apodo + ", nombre: " + nombre + ", nacionalidad: " + nacionalidad
				+ ", fechaNacimiento: " + fechaNacimiento;
	}
	
	
	
}
