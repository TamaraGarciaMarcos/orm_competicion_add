package Datos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import DAO.EquipoDAO;
import Modelo.Equipo;
import Modelo.Jugador;

public class DatosEquipos {

    private List<Equipo> equipos;

    public DatosEquipos() {
        equipos = new ArrayList<>();
        inicializarEquipos();
    }

    public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	private void inicializarEquipos() {

        equipos.add(new Equipo("Astralis"));
        equipos.add(new Equipo("Excel"));
        equipos.add(new Equipo("Fnatic"));
        equipos.add(new Equipo("G2 Sports"));
        equipos.add(new Equipo("KOI"));
        equipos.add(new Equipo("Mad Lions"));
        equipos.add(new Equipo("SK Gaming"));
        equipos.add(new Equipo("Team Heretics"));
        equipos.add(new Equipo("Team Vitality"));

        DatosJugadores datosJugador = new DatosJugadores(); // Instancia de DatosJugador

        for (Equipo equipo : equipos) {
            List<Jugador> jugadoresEquipo = datosJugador.obtenerJugadoresPorEquipo(equipo.getNombre());

            // Asigna los jugadores al equipo
            equipo.setPlantilla(jugadoresEquipo);
        }
    }

    public void persistirEquipos() {
        EquipoDAO equipoDAO = new EquipoDAO();

        for (Equipo equipo : equipos) {
            equipoDAO.insert(equipo);
        }
    }

    public Equipo buscarEquipoPorNombre(String nombre) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombre)) {
                return equipo;
            }
        }
        return null; // Retorna null si no se encuentra ningún equipo con el nombre dado
    }

    public static Equipo obtenerEquipoAleatorio(List<Equipo> listaEquipos) {
        if (listaEquipos == null || listaEquipos.isEmpty()) {
            throw new IllegalArgumentException("La lista de equipos no puede ser nula o vacía");
        }

        Random random = new Random();
        int indiceAleatorio = random.nextInt(listaEquipos.size());

        return listaEquipos.get(indiceAleatorio);
    }
}
