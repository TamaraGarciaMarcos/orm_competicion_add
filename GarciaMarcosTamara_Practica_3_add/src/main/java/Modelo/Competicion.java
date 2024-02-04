package Modelo;
/**
 * Esta clase se encarga de simular el modelo de la competicion 
 * 
 * @author Tamara Garcia Marcos
 */
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Competition")
public class Competicion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String fecha;
    
    @OneToMany()
    private List<Equipo> equiposParticipantes = new ArrayList<>();
    
    private List<Jugador> mejoresJugadores = new ArrayList<>();

    // Constructor
    public Competicion(String nombre, String fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    //getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Equipo> getEquiposParticipantes() {
        return equiposParticipantes;
    }

    public void setEquiposParticipantes(List<Equipo> equiposParticipantes) {
        this.equiposParticipantes = equiposParticipantes;
    }

    public List<Jugador> getMejoresJugadores() {
        return mejoresJugadores;
    }

    public void setMejoresJugadores(List<Jugador> mejoresJugadores) {
        this.mejoresJugadores = mejoresJugadores;
    }

    // Métodos propios
    public void agregarEquipo(Equipo equipo) {
        equiposParticipantes.add(equipo);
        
    }

    public void eliminarEquipo(Equipo equipo) {
        equiposParticipantes.remove(equipo);
       
    }

    public void agregarJugador(Jugador jugador) {
        mejoresJugadores.add(jugador);
    }

    public void eliminarJugador(Jugador jugador) {
        mejoresJugadores.remove(jugador);
    }

    // Método toString
    @Override
    public String toString() {
        return "Competicion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaInicio='" + fecha + '\'' +
                ", equiposParticipantes=" + equiposParticipantes +
                ", mejoresJugadores=" + mejoresJugadores +
                '}';
    }



}

