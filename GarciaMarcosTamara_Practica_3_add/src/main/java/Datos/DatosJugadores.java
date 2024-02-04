
package Datos;

/**
 * Esta clase se encarga de almacenar los datos de los jugadores

 * 
 * @author Tamara Garcia Marcos
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;

import Modelo.Jugador;

public class DatosJugadores {

	private Logger log;
    private Map<String, List<Jugador>> equipos;

    public DatosJugadores() {
        equipos = new HashMap<>();
        inicializarJugadores();
    }

    private void inicializarJugadores() {
    	
        // Astralis
    	List<Jugador> equipo1 = new ArrayList<Jugador>();
    	
    	equipo1.add(new Jugador("Finn", "Finn Wiestal", "Suecia", 27, "Top"));
    	equipo1.add(new Jugador("113", "Dogukan Balch", "Turquía", 20, "Jungla"));
    	equipo1.add(new Jugador("Dajor","Oliver Rippa","Alemania", 21 ,"Mid"));
    	equipo1.add(new Jugador("Kobbe","Kasper Kobbertup","Dinamarca", 28 ,"Bot"));
    	equipo1.add(new Jugador("JeongHoon","Lee Jeong-Hoon","Korea del Sur", 24 ,"Support"));
        agregarEquipos("Astralis",equipo1);

        // Excel
        List<Jugador> equipo2 = new ArrayList<Jugador>();
        equipo2.add(new Jugador("Odoamne", "Andrei Pascu", "Rumania", 29, "Top"));
        equipo2.add(new Jugador("Xerxe", "Andrei Dragomir", "Rumania", 26, "Jungla"));
        equipo2.add(new Jugador("Vetheo","Vincent Berrié","Francia",  22 ,"Mid"));
        equipo2.add(new Jugador("Patrick","Patrick Jirú","Republica Checa", 24 ,"Bot"));
        equipo2.add(new Jugador("Targamas","Rapphael Crabbé","Bélgica", 24 ,"Support"));
        agregarEquipos("Excel",equipo2);

        // Fnatic
        List<Jugador> equipo3 = new ArrayList<Jugador>();
        equipo3.add( new Jugador("Wunder", "Martin Nordahl", "Dinamarca", 26, "Top"));
        equipo3.add( new Jugador("Razork", "Ivan Martin", "España", 24, "Jungla"));
        equipo3.add(new Jugador("Humanoid","Marek Brazda","Republica Checa", 24 ,"Mid"));
        equipo3.add(new Jugador("Rekkles","Carl Martin","Suecia", 28 ,"Bot"));
        equipo3.add(new Jugador("Rhuckz","Rubén Barbosa","Protugal", 28 ,"Support"));
        agregarEquipos("Fnatic",equipo3);

        // G2 Sports
        List<Jugador> equipo4 = new ArrayList<Jugador>();
        equipo4.add(new Jugador("BrokenBlade", "Sergen Çelic", "Alemania", 24, "Top"));
        equipo4.add(new Jugador("Yike", "Martin Sundelin", "Suecia", 24, "Jungla"));
        equipo4.add(new Jugador("Caps","Rasmus Borregard","Dinamarca", 25 ,"Mid"));
        equipo4.add(new Jugador("MansSama","Steven Liv","Francia", 25 ,"Bot"));
        equipo4.add(new Jugador("Mikyx","Mihael Mehle","Eslovenia", 31 ,"Support"));
        agregarEquipos("G2 Sports",equipo4);

        // KOI
        List<Jugador> equipo5 = new ArrayList<Jugador>();
        equipo5.add( new Jugador("Szygenda", "Mathias Jensen", "Dinamarca", 23, "Top"));
        equipo5.add( new Jugador("Marlang", "Kim Geun-Sendg", "Korea del Sur", 24, "Jungla"));
        equipo5.add(new Jugador("Larssen","Emil Larsson","Suecia", 24 ,"Mid"));
        equipo5.add(new Jugador("Comp","Markos Stamkopoulos","Grecia", 23 ,"Bot"));
        equipo5.add(new Jugador("Trimby","Adrian Tribu","Polonia", 24 ,"Support"));
        agregarEquipos("KOI",equipo5);

        //Mad Lions
        List<Jugador> equipo6 = new ArrayList<Jugador>();
        equipo6.add(new Jugador("Chasy","Kim Dong-Hyeon","Korea del Sur", 23 ,"Top"));
        equipo6.add(new Jugador("ElYoya","Javier Prades","España", 24 ,"Jungla"));
        equipo6.add(new Jugador("Nisqy","Yasin Dincer","Bélgica", 26 ,"Mid"));
        equipo6.add(new Jugador("Carzzy","Matias Orsag","República Checa", 23 ,"Bot"));
        equipo6.add(new Jugador("Hylissang","Zdravets","Bulgaria", 29 ,"Support"));
        agregarEquipos("Mad Lions",equipo6);
    	
    	//SK Gaming
        List<Jugador> equipo7 = new ArrayList<Jugador>();
        equipo7.add(new Jugador("Irrelevant","Joel Miro","Alemania", 22,"Top"));
        equipo7.add(new Jugador("Markoon","Mark Van Woensei","Paises Bajos", 22 ,"Jungla"));
        equipo7.add(new Jugador("Sertuss","Daniel Gamani","Alemania", 23 ,"Mid"));
        equipo7.add(new Jugador("Exakick","Thomas Foucou","Francia", 21 ,"Bot"));
        equipo7.add(new Jugador("Doss","Mads Schwartz","Dinamarca", 25 ,"Support"));
    	agregarEquipos("SK Gaming",equipo7);
    	
    	//Team BDS
    	List<Jugador> equipo8 = new ArrayList<Jugador>();
    	equipo8.add(new Jugador("Adam","Adam Maanane","Francia", 23 ,"Top"));
    	equipo8.add(new Jugador("Sheo","Theo Borile","Francia", 23 ,"Jungla"));
    	equipo8.add(new Jugador("Nuc","Illias Bizriken","Francia", 22 ,"Mid"));
    	equipo8.add(new Jugador("Crownie","Jus Marusic","Eslovenia",26 ,"Bot"));
    	equipo8.add(new Jugador("Labroy","Labros Patoutsakis","Grecia", 22 ,"Support"));
    	agregarEquipos("Team BDS",equipo8);
    	
    	//Team Heretics 
    	List<Jugador> equipo9 = new ArrayList<Jugador>();
    	equipo9.add(new Jugador("Evi","Shunsuke Murase","Japon", 29 ,"Top"));
    	equipo9.add(new Jugador("Jankos","Marcin Jankowski","Polonia", 29 ,"Jungla"));
    	equipo9.add(new Jugador("Ruby","Lee Sol-min","Korea del Sur", 26 ,"Mid"));
    	equipo9.add(new Jugador("JackSpektra","Jacob Gulivan","Noruega", 24 ,"Bot"));
    	equipo9.add(new Jugador("Mersa","Mertai Sari","Grecia", 22 ,"Support"));
    	agregarEquipos("Team Heretics",equipo9);
    	
    	//Team Vitality
    	List<Jugador> equipo10 = new ArrayList<Jugador>();
    	equipo10.add(new Jugador("Photon","Kyeong Gyun-Tae","Korea del Sur", 23 ,"Top"));
    	equipo10.add(new Jugador("Bo","Zhou Yang-Bo","China", 22 ,"Jungla"));
    	equipo10.add(new Jugador("Perkz","Luka Perkovic","Croacia", 26,"Mid"));
    	equipo10.add(new Jugador("Neon","Matús Jakubcik","Eslovaquia", 25 ,"Bot"));
    	equipo10.add(new Jugador("Kaiser","Norman Kaiser","Alemania", 26 ,"Support"));
    	agregarEquipos("Team Vitality",equipo10);

    }

    private void agregarEquipos(String nombreEquipo, List<Jugador> equipo) {
        if (!equipos.containsKey(nombreEquipo)) {
            equipos.put(nombreEquipo, new ArrayList<>(equipo));
        } else {
            equipos.get(nombreEquipo).addAll(equipo);
            
        }
    }


    public Jugador buscarJugadorPorNombre(String nombre) {
        for (List<Jugador> jugadoresEquipo : equipos.values()) {
            for (Jugador jugador : jugadoresEquipo) {
                if (jugador.getNombre().equalsIgnoreCase(nombre)) {
                    return jugador;
                }
            }
        }
        log.info("No se ha encontrado ningun jugador con ese nombre");
        return null; // Retorna null si no se encuentra ningún jugador con el nombre dado
    }
    
    public List<Jugador> obtenerTodosLosJugadores() {
        List<Jugador> todosLosJugadores = new ArrayList<>();

        for (List<Jugador> jugadoresEquipo : equipos.values()) {
            todosLosJugadores.addAll(jugadoresEquipo);
        }
        
        return todosLosJugadores;
    }

    public List<Jugador> obtenerJugadoresPorEquipo(String nombreEquipo) {
        List<Jugador> jugadoresDelEquipo = new ArrayList<>();

        for (Map.Entry<String, List<Jugador>> entry : equipos.entrySet()) {
            String nombreEquipoActual = entry.getKey();
            List<Jugador> jugadoresEquipoActual = entry.getValue();

            if (nombreEquipoActual.equalsIgnoreCase(nombreEquipo)) {
                jugadoresDelEquipo.addAll(jugadoresEquipoActual);
            }
        }
        return jugadoresDelEquipo;
    }
}

