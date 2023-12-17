package estadisticasLiga;

import temporada.Temporada;

public class estadisticasLiga {

	 public static void main(String[] args) {
	        Temporada temporada=new Temporada("2022", "C:\\Users\\sergi\\eclipse-workspace\\prat.mp05.act1.Garcia.Vila.Sergi\\src\\SP1.csv");
	        
	        temporada.calcular_clasificacion();
	        temporada.imprime_clasificacion();

	        //temporada.diccionario_partidos_ganados();
	        //temporada.imprimir_diccionario();
	        //temporada.imprimir_partidos();
	        
	        /*System.out.println("Media de goles que mete el equipo local: "+
	                temporada.media_goles_equipos_locales());
	        System.out.println("Media de goles que mete el Betis como local: "+
	                temporada.media_goles_equipos_locales("Betis"));
	        System.out.println("Media de goles que mete el Betis como visitante: "+
	                temporada.media_goles_equipos_visitantes("Betis"));
	        */
	        
	        //System.out.println("Media de Goles que ha recibido el Betis: "+temporada.calcula_media_de_goles_recibidos("Betis"));

	        
	    }
}
