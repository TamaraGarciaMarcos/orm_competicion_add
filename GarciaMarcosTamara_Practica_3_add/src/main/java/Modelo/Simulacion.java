package Modelo;

import java.util.List;
import java.util.Random;

public class Simulacion {

    public static void main(String[] args) {
        // Crear una competición de ejemplo
        Competicion lec = new Competicion("LEC League of Legends", "2023");

        // Obtener la lista de equipos participantes en la competición
        List<Equipo> equipos = lec.getEquiposParticipantes();

        // Simular algunos aspectos, como partidos, estadísticas, etc.
        simularPartidos(equipos);
        mostrarEstadisticas(lec);
    }

    public static void simularPartidos(List<Equipo> equipos) {
        System.out.println("Simulación de partidos:");

        Random random = new Random();

        for (int i = 0; i < equipos.size(); i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                Equipo equipoLocal = equipos.get(i);
                Equipo equipoVisitante = equipos.get(j);
                // Simulación de resultado aleatorio (ganar o perder)
                boolean localGana = random.nextBoolean();
                // Actualizar estadísticas de equipos y jugadores
                actualizarEstadisticas(equipoLocal, equipoVisitante, localGana);
                // Imprimir resultado del partido
                if (localGana) {
                    System.out.println(equipoLocal.getNombre() + " gana contra " + equipoVisitante.getNombre());
                } else {
                    System.out.println(equipoVisitante.getNombre() + " gana contra " + equipoLocal.getNombre());
                }
            }
        }
    }
    private static void actualizarEstadisticas(Equipo equipoLocal, Equipo equipoVisitante, boolean localGana) {
        // Actualizar estadísticas de equipos
        if (localGana) {
            equipoLocal.incrementarVictorias();
            equipoVisitante.incrementarDerrotas();
        } else {
            equipoLocal.incrementarDerrotas();
            equipoVisitante.incrementarVictorias();
        }
    }

    private static void mostrarEstadisticas(Competicion competicion) {
        System.out.println("\nEstadísticas de la competición:");

        //Mostrar equipos con más victorias
        System.out.println("Equipos con más victorias:");
        for (Equipo equipo : competicion.getEquiposParticipantes()) {
            System.out.println(equipo.getNombre() + " - Victorias: " + equipo.getVctorias());
        }

        //Mostrar mejores jugadores
        System.out.println("Mejores jugadores:");
        for (Jugador jugador : competicion.getMejoresJugadores()) {
            System.out.println(jugador.getNombre() + " - Posición: " + jugador.getPosicion());
        }
    }
}

