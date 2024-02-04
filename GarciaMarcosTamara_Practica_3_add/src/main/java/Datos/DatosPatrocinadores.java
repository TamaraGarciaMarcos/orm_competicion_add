package Datos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Modelo.Patrocinador;

public class DatosPatrocinadores {

    private Map<String, List<Patrocinador>> patrocinadores;

    public DatosPatrocinadores() {
        patrocinadores = new HashMap<>();
        inicializarPatrocinadores();
    }

    public Map<String, List<Patrocinador>> getPatrocinadores() {
		return patrocinadores;
	}

	public void setPatrocinadores(Map<String, List<Patrocinador>> patrocinadores) {
		this.patrocinadores = patrocinadores;
	}

	private void inicializarPatrocinadores() {
    	//Astralis
    	List<Patrocinador> equipo1 = new ArrayList<Patrocinador>();
    	equipo1.add(new Patrocinador("Audi"));
    	equipo1.add(new Patrocinador("Logitech G"));
    	agregarPatrocinador("Astralis",equipo1);
    	
    	//Excel
    	List<Patrocinador> equipo2 = new ArrayList<Patrocinador>();
    	equipo1.add(new Patrocinador("Just Eat"));
    	equipo1.add(new Patrocinador("JD Sports"));
    	agregarPatrocinador("Excel",equipo2);
    	
    	//Fnatic
    	List<Patrocinador> equipo3 = new ArrayList<Patrocinador>();
    	equipo1.add(new Patrocinador("Monster Energy"));
    	equipo1.add(new Patrocinador("Asos"));
    	agregarPatrocinador("Fnatic",equipo3);
    	
    	//G2 Sports
    	List<Patrocinador> equipo4 = new ArrayList<Patrocinador>();
    	equipo1.add(new Patrocinador("Adidas"));
    	equipo1.add(new Patrocinador("Logitech G"));
    	agregarPatrocinador("G2 Sports",equipo4);
    	
    	//Koi
    	List<Patrocinador> equipo5 = new ArrayList<Patrocinador>();
    	equipo1.add(new Patrocinador("Nike"));
    	equipo1.add(new Patrocinador("Cupra"));
    	agregarPatrocinador("KOI",equipo5);
    	
    	//Mad Lions 
    	List<Patrocinador> equipo6 = new ArrayList<Patrocinador>();
    	equipo1.add(new Patrocinador("Overactive Media"));
    	agregarPatrocinador("Mad Lions",equipo6);
    	
    	//SK Gaming
    	List<Patrocinador> equipo7 = new ArrayList<Patrocinador>();
    	equipo1.add(new Patrocinador("Mercedes-Benz"));
    	equipo1.add(new Patrocinador("NH Hotel"));
    	agregarPatrocinador("SK Gaming",equipo7);
    	
    	//Team Heretics
    	List<Patrocinador> equipo8 = new ArrayList<Patrocinador>();
    	equipo1.add(new Patrocinador("Ozone Gaming Gear"));
    	equipo1.add(new Patrocinador("Gfuel"));
    	agregarPatrocinador("Team Heretics",equipo8);
    	
    	//Team BDS no tiene patrocinador
    	
    	//Team Vitality
    	List<Patrocinador> equipo10 = new ArrayList<Patrocinador>();
    	equipo1.add(new Patrocinador("Hummel"));
    	equipo1.add(new Patrocinador("Garnier Fructis"));
    	agregarPatrocinador("Astralis",equipo10);

    }

    private void agregarPatrocinador(String nombreEquipo, List<Patrocinador> equipo) {
        if (!patrocinadores.containsKey(nombreEquipo)) {
            patrocinadores.put(nombreEquipo, new ArrayList<>(equipo));
        } else {
            patrocinadores.get(nombreEquipo).addAll(equipo);
        }
    }

    public List<Patrocinador> obtenerPatrocinadoresDeEquipo(String nombreEquipo) {
        return patrocinadores.get(nombreEquipo);
    }

    public Patrocinador buscarPatrocinadorPorNombre(String nombre) {
        for (List<Patrocinador> patrocinadoresEquipo : patrocinadores.values()) {
            for (Patrocinador patrocinador : patrocinadoresEquipo) {
                if (patrocinador.getNombre().equalsIgnoreCase(nombre)) {
                    return patrocinador;
                }
            }
        }
        return null; // Retorna null si no se encuentra ningún patrocinador con el nombre dado
    }
}