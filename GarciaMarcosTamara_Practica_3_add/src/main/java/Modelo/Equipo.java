package Modelo;
/**
 * Esta clase se encarga de simular a un equipo de la competicion

 * 
 * @author Tamara Garcia Marcos
 */
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="equip")
public class Equipo {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="Name")
    private String nombre;
	@Column(name="Wins")
    private int victorias;
	
	@Column(name="Loses")
    private int derrotas;
	@Column(name="Players")	
	@OneToMany(mappedBy = "equipo") // Relación OneToMany con la clase Jugador
    private List<Jugador> plantilla;
	
	@OneToOne(mappedBy = "entrenador")
	private Entrenador entrenador;
	
	@Column(name="Sponsors")
	@ManyToMany
	@JoinTable(
       name = "Equipo_Patrocinador", 
       joinColumns = @JoinColumn(name = "equipo_id"), 
       inverseJoinColumns = @JoinColumn(name = "patrocinador_id")
	)
    private List<Patrocinador> patrocinadores;    
	
    // Constructor
    public Equipo(int id, String nombre, Entrenador entrenador) {
        this.id = id;
        this.nombre = nombre;
        this.entrenador=entrenador;
        this.plantilla = new ArrayList<>();
        this.patrocinadores= new ArrayList<>();
    }

    public Equipo( String nombre, Entrenador entrenador) {
        this.nombre = nombre;
        this.entrenador=entrenador;
        this.plantilla = new ArrayList<>();
        this.patrocinadores= new ArrayList<>();
    }
    
    public Equipo( String nombre) {
        this.nombre = nombre;
        this.plantilla = new ArrayList<>();
        this.patrocinadores= new ArrayList<>();
    }
    
    // Getters y setters

    public int getVictorias() {
		return victorias;
	}

	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
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

    public List<Jugador> getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(List<Jugador> plantilla) {
        this.plantilla = plantilla;
    }

    public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getVctorias() {
		return victorias;
	}

	public void setVctorias(int vctorias) {
		this.victorias = vctorias;
	}

	public List<Patrocinador> getPatrocinadores() {
		return patrocinadores;
	}

	public void setPatrocinadores(List<Patrocinador> patrocinadores) {
		this.patrocinadores = patrocinadores;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", vctorias=" + victorias + ", derrotas=" + derrotas
				+ ", plantilla=" + plantilla + ", patrocinadores=" + patrocinadores + "]";
	}
	
	// Métodos adicionales

    public void agregarJugador(Jugador jugador) {
        plantilla.add(jugador);
    }

    public void eliminarJugador(Jugador jugador) {
        plantilla.remove(jugador);
    }

    public void agregarPatrocinador(Patrocinador patrocinador) {
        if (patrocinadores == null) {
            patrocinadores = new ArrayList<>();
        }
        patrocinadores.add(patrocinador);
    }

    public void eliminarPatrocinador(Patrocinador patrocinador) {
        if (patrocinadores != null) {
            patrocinadores.remove(patrocinador);
        }
    }
	
    public void incrementarVictorias() {
        victorias++;
    }

    public void incrementarDerrotas() {
        derrotas++;
    }
    public List<Jugador> getJugadores() {
        return plantilla;
    }

	
}
