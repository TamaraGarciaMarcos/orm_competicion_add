package Modelo;
/**
 * Esta clase se encarga de simular un jugador de la competicion

 * @author Tamara Garcia Marcos
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Player")
public class Jugador {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "Nickname")
	private String apodo;
	@Column(name = "Name")
	private String nombre;
	@Column(name = "Country")
	private String nacionalidad;
	@Column(name = "age")
	private int edad;
	@Column(name = "Position")
	private String posicion;
	@Column(name="newPlayer")
	private boolean nuevoFichaje;

	@ManyToOne
	@JoinColumn(name="team_id")
	private Equipo equipo; // Relación ManyToOne con la clase Equipo

	// Constructor
	public Jugador(String apodo, String nombre, String nacionalidad, int edad, String posicion) {
		this.apodo = apodo;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.edad = edad;
		this.posicion = posicion;
	}
	
	public Jugador(String apodo, String nombre, String nacionalidad, int edad, String posicion, Equipo equipo, boolean nuevoFichaje) {
		this.apodo = apodo;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.edad = edad;
		this.posicion = posicion;
		this.nuevoFichaje=nuevoFichaje;
	}

	public Jugador(long id, String apodo, String nombre, String nacionalidad, int edad, String posicion) {
		this.id = id;
		this.apodo = apodo;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.edad = edad;
		this.posicion = posicion;
	}

	// Getters y setters
	
	public void setId(long id) {
		this.id = id;
	}

	public boolean isNuevoFichaje() {
		return nuevoFichaje;
	}

	public void setNuevoFichaje(boolean nuevoFichaje) {
		this.nuevoFichaje = nuevoFichaje;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public long getId() {
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

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return nombre + ", Nacionalidad: " + nacionalidad + ", Fecha de Nacimiento: " + edad;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}
}
