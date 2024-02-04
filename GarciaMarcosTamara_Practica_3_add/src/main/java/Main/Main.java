package Main;
import java.util.List;

import org.apache.logging.log4j.Logger;

import DAO.CompeticionDAO;
import DAO.EquipoDAO;
import DAO.JugadorDAO;
import DAO.PatrocinadorDAO;
import Datos.DatosEquipos;
import Datos.DatosJugadores;
import Datos.DatosPatrocinadores;
import Modelo.Competicion;
import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Patrocinador;
import Modelo.Simulacion;
import Querys.ConsultasCompeticion;

public class Main {

	private Logger log;
	
	public static void main(String[] args) {		
		
		Simulacion simulacion = new Simulacion();
        JugadorDAO jugadorDAO = new JugadorDAO();
        EquipoDAO equipoDAO = new EquipoDAO();
        PatrocinadorDAO patrocinadorDAO = new PatrocinadorDAO();
        CompeticionDAO competicionDAO = new CompeticionDAO();
        DatosEquipos datosEquipos = new DatosEquipos();
		DatosPatrocinadores datosPatrocinadores = new DatosPatrocinadores();
		Competicion lec = new Competicion("LEC League of Legends", "2023");
		ConsultasCompeticion consulta= new ConsultasCompeticion();
		
		// Crear instancia de DatosJugadores
        DatosJugadores datosJugadores = new DatosJugadores();

        // Obtener la lista de jugadores desde DatosJugadores
        List<Jugador> jugadores = datosJugadores.obtenerTodosLosJugadores();

        // Insertar cada jugador en la base de datos
        for (Jugador jugador : jugadores) {
            jugadorDAO.insert(jugador);
        }
        
        // Obtener la lista de equipos desde DatosEquipos
        List<Equipo> equipos = datosEquipos.getEquipos();

        // Insertar cada equipo en la base de datos
        for (Equipo equipo : equipos) {
            equipoDAO.insert(equipo);
        }
        
        // Obtener la lista de patrocinadores desde DatosPatrocinadores
        List<Patrocinador> patrocinadores = (List<Patrocinador>) datosPatrocinadores.getPatrocinadores();

        // Insertar cada patrocinador en la base de datos
        for (Patrocinador patrocinador : patrocinadores) {
            patrocinadorDAO.insert(patrocinador);
        }
        
      //persistencia competicion
      	competicionDAO.insert(lec);
      		
      	//Simulación de las jornadas. Jornada 1
      	simulacion.simularPartidos(equipos);
      	System.out.println("Consulta 8 al inicio de la competion:");
        consulta.consulta8();
        //Simulacion segunda Jornada
        simulacion.simularPartidos(equipos);
        System.out.println("Consulta 8 a mitad de competición: ");
      	consulta.consulta8();
      	//Simulacion tercera jornada de la competicion:
      	simulacion.simularPartidos(equipos);
      	System.out.println("Consulta 8 al final de la simulacion de jornadadas:");
      	consulta.consulta8();
      	
      	//Generación de las consultas:
      	consulta.consulta1();
      	consulta.consulta2();
      	consulta.consulta3(datosEquipos.obtenerEquipoAleatorio(equipos));
      	consulta.consulta4(datosEquipos.obtenerEquipoAleatorio(equipos));
      	consulta.consulta5(datosEquipos.obtenerEquipoAleatorio(equipos));
      	consulta.consulta6(datosEquipos.obtenerEquipoAleatorio(equipos));
      	consulta.consulta7();
      	consulta.consulta9();
      	consulta.consulta10();
      	consulta.consulta11();
      	consulta.consulta12();
      	consulta.consulta13(datosEquipos.obtenerEquipoAleatorio(equipos),datosEquipos.obtenerEquipoAleatorio(equipos));
      	consulta.consulta14();
      	
        // Cerrar EntityManager y EntityManagerFactory al finalizar
        jugadorDAO.cerrarRecursos();
        equipoDAO.cerrarRecursos();
        patrocinadorDAO.cerrarRecursos();
		
		

	}
	
}
