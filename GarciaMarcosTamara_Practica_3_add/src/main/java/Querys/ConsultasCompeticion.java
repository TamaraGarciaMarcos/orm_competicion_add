package Querys;

import java.util.List;

import org.apache.logging.log4j.Logger;

import Modelo.Competicion;
import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Patrocinador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class ConsultasCompeticion {

	private Logger log;
	private EntityManagerFactory emf;
	private EntityManager em;

	public void consulta1() {
		System.out.println(
				"Consulta 1. Utiliza una consulta nativa(NativeQuery) para obtener las características de la competición.");
		String sql = "SELECT * FROM Competition";
		List<Competicion> competiciones = em.createNativeQuery(sql, Competicion.class).getResultList();
		System.out.println(competiciones);
		System.out.println("-------------------- Fin Consulta 1 --------------------");
	}

	public void consulta2() {
		System.out.println("Consulta 2. Consulta y recupera todos lo equipos participantes en la competición.");
		String hqlEquipos = "FROM Equipo";
		List<Equipo> equipos = em.createQuery(hqlEquipos, Equipo.class).getResultList();
		System.out.println(equipos);

		System.out.println("-------------------- Fin Consulta 2 --------------------");
	}

	public void consulta3(Equipo equipo) {
		System.out.println("Consulta 3. Obtén la lista de todos los deportistas de un equipo específico.");
		String hqlDeportistas = "FROM Jugador j WHERE j.equipo = :equipo";
		List<Jugador> deportistas = em.createQuery(hqlDeportistas, Jugador.class)
				.setParameter("equipo", equipo.getNombre()).getResultList();
		System.out.println(deportistas);
		System.out.println("-------------------- Fin Consulta 3 --------------------");
	}

	public void consulta4(Equipo equipo) {
		System.out.println("Consulta 4. Identifica y lista todos los patrocinadores asociados a un equipo concreto.");
		String hqlPatrocinadores = "FROM Patrocinador p WHERE p.equipo = :equipo";
		List<Patrocinador> patrocinadores = em.createQuery(hqlPatrocinadores, Patrocinador.class)
				.setParameter("equipo", equipo.getNombre()).getResultList();
		System.out.println(patrocinadores);
		System.out.println("-------------------- Fin Consulta 4 --------------------");
	}

	public void consulta5(Equipo equipo) {
		System.out.println(
				"Consulta 5. Genera una lista de deportistas y patrocinadores vinculados a un equipo específico.");
		String hqlDeportistasPatrocinadores = "SELECT j, p FROM Jugador j JOIN j.patrocinador p WHERE j.equipo = :equipo";
		List<Object[]> resultados = em.createQuery(hqlDeportistasPatrocinadores, Object[].class)
				.setParameter("equipo", equipo.getNombre()).getResultList();
		// resultados contendrá un array de objetos, donde [0] es el Jugador y [1] es el
		// Patrocinador asociado.
		System.out.println(resultados);
		System.out.println("-------------------- Fin Consulta 5 --------------------");
	}

	public void consulta6(Equipo equipo) {
		System.out.println(
				"Consulta 6. Calcula y presenta la edad promedio de los deportistas de un equipo determinado.");
		String jpqlEdadPromedio = "SELECT AVG(j.edad) FROM Jugador j WHERE j.equipo = :equipo";
		Double edadPromedio = em.createQuery(jpqlEdadPromedio, Double.class).setParameter("equipo", equipo.getNombre())
				.getSingleResult();
		System.out.println("La edad promedio es " + edadPromedio);
		System.out.println("-------------------- Fin Consulta 6 --------------------");
	}

	public void consulta7() {
		System.out.println("Consulta 7. Cuenta cuantos deportistas tienen más de veintitrés años en la\r\n"
				+ "competición agrupados por nacionalidad.");
		String jpqlContarPorNacionalidad = "SELECT j.nacionalidad, COUNT(j) FROM Jugador j WHERE j.edad > 23 GROUP BY j.nacionalidad";
		List<Object[]> resultadosConteo = em.createQuery(jpqlContarPorNacionalidad, Object[].class).getResultList();
		System.out.println(resultadosConteo);
		System.out.println("-------------------- Fin Consulta 7 --------------------");
	}

	public void consulta8() {
		System.out
				.println("Consulta 8. Visualiza la clasificación al inicio, a mitad de temporada y al final de esta.");
		String jpql = "SELECT e FROM Equipo e " + "JOIN e.competicion c " + "WHERE c.nombre = :nombreCompeticion "
				+ "ORDER BY c.momento, e.victorias DESC";
		TypedQuery<Equipo> query = em.createQuery(jpql, Equipo.class);
		query.setParameter("nombreCompeticion", "LEC League of Legends");

		List<Equipo> clasificacion = query.getResultList();
		System.out.println(clasificacion);
		System.out.println("-------------------- Fin Consulta 8 --------------------");
	}

	public void consulta9() {
		System.out.println(
				"Consulta 9. Determina y muestra los tres equipos con más puntos y los tres\r\n" + "con menos.");
		String jpqlMejoresEquipos = "SELECT e FROM Equipo e ORDER BY e.puntos DESC";
		List<Equipo> mejoresEquipos = em.createQuery(jpqlMejoresEquipos, Equipo.class).setMaxResults(3).getResultList();

		String jpqlPeoresEquipos = "SELECT e FROM Equipo e ORDER BY e.puntos ASC";
		List<Equipo> peoresEquipos = em.createQuery(jpqlPeoresEquipos, Equipo.class).setMaxResults(3).getResultList();
		System.out.println("los mejores equipos son: " + mejoresEquipos);
		System.out.println("Los peores equipos son: " + peoresEquipos);
		System.out.println("-------------------- Fin Consulta 9 --------------------");
	}

	public void consulta10() {
		System.out.println(
				"Consulta 10. Muestra las nuevas incorporaciones a la competición(utiliza una\r\n" + "NamedQuery).");
		List<Jugador> nuevasIncorporaciones = em.createNamedQuery("NuevasIncorporaciones", Jugador.class)
				.getResultList();
		System.out.println("Las nuevas incorporaciones son: " + nuevasIncorporaciones);
		System.out.println("-------------------- Fin Consulta 10 --------------------");
	}

	public void consulta11() {
		System.out.println("Consulta 11. Enumera todos los fichajes realizados entre los diferentes equipos");
		String hqlFichajes = "SELECT j.nombre, e.nombre FROM Jugador j JOIN j.equipo e";
		List<Object[]> fichajes = em.createQuery(hqlFichajes, Object[].class).getResultList();
		System.out.println(fichajes);
		System.out.println("-------------------- Fin Consulta 11 --------------------");
	}

	public void consulta12() {
		System.out
				.println("Consulta 12. Realiza un recuento del total de deportistas que participan en la competición.");
		String hqlConteoDeportistas = "SELECT COUNT(j) FROM Jugador j";
		Long totalDeportistas = em.createQuery(hqlConteoDeportistas, Long.class).getSingleResult();
		System.out.println("Total de deportistas: " + totalDeportistas);
		System.out.println("-------------------- Fin Consulta 12 --------------------");
	}

	public void consulta13(Equipo equipo1, Equipo equipo2) {
		System.out.println("Consulta 13. Dado dos equipos muestra sus patrocinadores comunes.");
		String hqlPatrocinadoresComunes = "SELECT p FROM Patrocinador p WHERE p.equipo IN (:equipo1, :equipo2)";
		List<Patrocinador> patrocinadoresComunes = em.createQuery(hqlPatrocinadoresComunes, Patrocinador.class)
				.setParameter("equipo1", equipo1).setParameter("equipo2", equipo2).getResultList();
		System.out.println("Los patrocinadores comunes son: " + patrocinadoresComunes);
		System.out.println("-------------------- Fin Consulta 13 --------------------");
	}

	public void consulta14() {
		System.out.println("Consulta 14. Utiliza CriteriaQuery para poder filtrar por todos los atributos de\r\n"
				+ "los deportistas, edad, nombre, equipo, etc ordenados por un criterio. Lanza tres ejemplos distintos con \r\n"
				+ "diferentes atributos,uno debe incluir todos los atributos y el resto solo una parte de ellos.");
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Jugador> query1 = cb.createQuery(Jugador.class);
		Root<Jugador> root1 = query1.from(Jugador.class);
		query1.select(root1).where(cb.equal(root1.get("edad"), 25)).orderBy(cb.asc(root1.get("nombre")));
		List<Jugador> resultado = em.createQuery(query1).getResultList();
		System.out.println(resultado);
		System.out.println("-------------------- Fin Consulta 14 --------------------");
	}
	
	/*Consultas de la parte opcional:
	public void consulta15() {
		System.out.println("Consulta 15.Enumera la clasificación final de los equipos y la remuneración\r\n"
				+ "obtenida por cada uno según su posición.");
		String jpql = "SELECT e, e.remuneracion "
	            + "FROM Equipo e "
	            + "ORDER BY e.posicionFinal";
		TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
		List<Object[]> resultados = query.getResultList();
		for (Object[] resultado : resultados) {
	    Equipo equipo = (Equipo) resultado[0];
	    Double remuneracion = (Double) resultado[1];
	    System.out.println("Equipo: " + equipo.getNombre() + ", Posición Final: " + equipo.getPosicionFinal() + ", Remuneración: " + remuneracion);
	}
		System.out.println();
		System.out.println("-------------------- Fin Consulta 15 --------------------");
	}
	
	public void consulta16() {
		System.out.println("Consulta 16. Identifica al deportista que más frecuentemente ha sido nombrado BestPlayer en la\r\n"
				+ " competición, optando por aquel de un equipo peor clasificado en caso de empate entre varios deportistas");
		String jpql = "SELECT j, COUNT(j.bestPlayer) AS vecesNombrado "
            + "FROM Jugador j "
            + "WHERE j.bestPlayer = true "
            + "GROUP BY j "
            + "ORDER BY vecesNombrado DESC";
		TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
		List<Object[]> resultados = query.getResultList();
		Object[] mejorJugador = resultados.get(0);
		Jugador jugador = (Jugador) mejorJugador[0];
		Long vecesNombrado = (Long) mejorJugador[1];
		System.out.println("Mejor Jugador: " + jugador.getNombre() + ", Veces Nombrado BestPlayer: " + vecesNombrado);
		System.out.println();
		System.out.println("-------------------- Fin Consulta 16 --------------------");
	}
	
	public void consulta17() {
		System.out.println("Consulta 17.Ordena y presenta los patrocinadores de un equipo según la\r\n"
				+ "magnitud de su contribución financiera, de mayor a menor");
		String jpql = "SELECT p "
            + "FROM Patrocinador p "
            + "WHERE p.equipo.nombre = :nombreEquipo "
            + "ORDER BY p.contribucionFinanciera DESC";
		TypedQuery<Patrocinador> query = entityManager.createQuery(jpql, Patrocinador.class);
		query.setParameter("nombreEquipo", "NombreDelEquipo");
		List<Patrocinador> patrocinadores = query.getResultList();
		for (Patrocinador patrocinador : patrocinadores) {
    	System.out.println("Patrocinador: " + patrocinador.getNombre() + ", Contribución Financiera: " + patrocinador.getContribucionFinanciera());
		}
		
		System.out.println();
		System.out.println("-------------------- Fin Consulta 17 --------------------");
	}
	
	public void consulta18() {
		System.out.println("Consulta 18. Para un equipo específico, reporta el resultado de su partido en la tercera jornada\r\n"
				+ " de la competición, incluyendo todas las estadísticas relevantes de ese encuentro.");
		String jpql = "SELECT p "
            + "FROM Partido p "
            + "WHERE p.equipoLocal.nombre = :nombreEquipo OR p.equipoVisitante.nombre = :nombreEquipo "
            + "AND p.jornada = 3";
		TypedQuery<Partido> query = entityManager.createQuery(jpql, Partido.class);
		query.setParameter("nombreEquipo", "NombreDelEquipo");
		Partido partido = query.getSingleResult();
		System.out.println("Resultado del Partido: " + partido.getResultado() + ", Estadísticas: " + partido.getEstadisticas());

		System.out.println();
		System.out.println("-------------------- Fin Consulta 18 --------------------");
	}
	
	public void consulta19() {
		System.out.println("Consulta 19. Determina qué equipo ha generado la mayor cantidad de ingresos y calcula\r\n"
				+ " el total acumulado de dichos ingresos.");
		String jpql = "SELECT e, SUM(p.contribucionFinanciera) "
            + "FROM Equipo e "
            + "JOIN e.patrocinadores p "
            + "GROUP BY e "
            + "ORDER BY SUM(p.contribucionFinanciera) DESC";
		TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
		List<Object[]> resultados = query.getResultList();
		Object[] equipoConIngresosMaximos = resultados.get(0);
		Equipo equipoMaximoIngresos = (Equipo) equipoConIngresosMaximos[0];
		Double totalIngresos = (Double) equipoConIngresosMaximos[1];
		System.out.println("Equipo con más ingresos: " + equipoMaximoIngresos.getNombre() + ", Total de Ingresos: " + totalIngresos);

		System.out.println();
		System.out.println("-------------------- Fin Consulta 19 --------------------");
	}
	
	public void consulta20() {
		System.out.println("Consulta 20. Muestra al mejor jugador de cada enfrentamiento junto a qué\r\n"
				+ "equipo pertenece y contra que equipo se enfrentó, de cada jornada de la competición.");
		String jpql = "SELECT p.jornada, p.equipoLocal, p.equipoVisitante, j "
            + "FROM Partido p "
            + "JOIN p.mejorJugador j "
            + "WHERE j.bestPlayer = true "
            + "ORDER BY p.jornada";
		TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
		List<Object[]> resultados = query.getResultList();
		for (Object[] resultado : resultados) {
    	Integer jornada = (Integer) resultado[0];
    	Equipo equipoLocal = (Equipo) resultado[1];
    	Equipo equipoVisitante = (Equipo) resultado[2];
    	Jugador mejorJugador = (Jugador) resultado[3];
    	System.out.println("Jornada: " + jornada + ", Equipo Local: " + equipoLocal.getNombre() + ", Equipo Visitante: " + equipoVisitante.getNombre() + ", Mejor Jugador: " + mejorJugador.getNombre());
		}
		
		System.out.println();
		System.out.println("-------------------- Fin Consulta 20 --------------------");
	}*/
}
