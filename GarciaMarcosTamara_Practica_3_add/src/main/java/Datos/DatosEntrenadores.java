package Datos;

/**
 * Esta clase se encarga de almacenar los datos de los Entrenadores

 * 
 * @author Tamara Garcia Marcos
 */
import java.util.ArrayList;

import org.apache.logging.log4j.Logger;

import Modelo.Entrenador;

public class DatosEntrenadores {

	private Logger log;
	ArrayList<Entrenador> listaEntrenadores = new ArrayList<>();
	
	public DatosEntrenadores() {
		listaEntrenadores = new ArrayList<>();
		inicializarEntrenadores();
	}
	
	
	public void inicializarEntrenadores() {
		Entrenador ent1 = new Entrenador("AoD","Alin-Ciprian Valtat","Romania", "26-01-1993");//Astralis
		listaEntrenadores.add(ent1);
		Entrenador ent2 = new Entrenador("YoungBuck","Joey Steltenpool","Paises Bajos", "28-07-1991");//Excel
		listaEntrenadores.add(ent2);
		Entrenador ent3 = new Entrenador("Crusher","Gonçalo Pinto","Portugal", "24-08-1992");//Fnatic
		listaEntrenadores.add(ent3);
		Entrenador ent4 = new Entrenador("DylanFalco","Dylan Falco","Canadá", "05-03-1990");//G2
		listaEntrenadores.add(ent4);
		Entrenador ent5 = new Entrenador("Arvindir","Danusch Fischer","Alemania", "15-06-1995");//KOI
		listaEntrenadores.add(ent5);
		Entrenador ent6 = new Entrenador("Mac","James MacCormak","Reino Unido", "13-02-1994");//MadLions
		listaEntrenadores.add(ent6);
		Entrenador ent7 = new Entrenador("Own3r","David Rodriguez","España", "21-05-1994");//SK
		listaEntrenadores.add(ent7);
		Entrenador ent8 = new Entrenador("GoToOne","Adrien Picard","Francia", "08-06-1994");//BDS
		listaEntrenadores.add(ent8);
		Entrenador ent9 = new Entrenador("Peterdun","Peter Dun","Reino Unido", "24-07-1987");//Heretics
		listaEntrenadores.add(ent9);
		Entrenador ent10 = new Entrenador("Hjarnan","Petter Freyschuss","Suecia", "18-11-1993");//Vitality
		listaEntrenadores.add(ent10);
	}
	
	public void agregarEntrenador(Entrenador entrenador) {
        listaEntrenadores.add(entrenador);
    }
	
	public Entrenador buscarEntrenadorPorNombre(String nombre) {
        for (Entrenador entrenador : listaEntrenadores) {
            if (entrenador.getNombre().equals(nombre)) {
                return entrenador; // Se encontró el entrenador
            }
        }
        log.info("No se ha encontrado un entrenador con ese nombre");
        return null; // No se encontró el entrenador con ese nombre
    }
    
	
}
