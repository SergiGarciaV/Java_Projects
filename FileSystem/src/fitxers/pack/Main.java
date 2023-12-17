package fitxers.pack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[]args) {
		
		try {
		//saveOptimitzat("c:\\Pruebas\\doc.txt", "En un lugar de la mancha", false);
		String resultat = readOptimitzat("c:\\Pruebas\\doc.txt");
		System.out.print(resultat);
		}catch(IOException e){
			System.err.println(e.getMessage());
		}
	}
	//Si el booleano recibe un true significa que añade el contenido de + a + al contenido del fichero, si pasamos un 
	//false , elimina todo el contenido si es que lo hay y escribe el contenido. 
	private static void saveNoOptimitzat(String rutaFitxer, String contingut, boolean afegirContingutSiFitxerExisteix) throws IOException {
		
		
		File file=new File(rutaFitxer);
		
		//Nos obliga a tratar con try catch o bien añadirle un throw al método , si añadimos un throw al método significa
		//que el método que llame a este método tendrá que manejar el try except en esa llamada, o bien hacer otro throw
		// y que el método que llame a ese método haga el try catch... 
		
		//fileWriter recibe 2 parámetros. El 1º es la ruta en la que se escribirá, el segundo será un booleano que dice
		//que si el fichero ya existe añada esa info, y sinó lo crea de nuevo. 
		
		FileWriter fileWriter = new FileWriter(rutaFitxer, afegirContingutSiFitxerExisteix);
		fileWriter.write("\n"+contingut);
		fileWriter.close();
		
		
	}
	
	//Hace lo mismo que el anterior método, pero usando el bufferedWriter que ayudará a que en lugar de cargar el "contingut"
	//de String en String acumula 1º en un buffer todos los String que puede y luego los lleva hasta el SSD , haciendo que el viaje hasta 
	//el viaje sea + provechoso y haciendo la carga mucho + rápida y optimizada.  
	private static void saveOptimitzat(String rutaFitxer, String contingut, boolean afegirContingutSiFitxerExisteix) throws IOException {
		
		File file=new File(rutaFitxer);
		FileWriter fileWriter = new FileWriter(rutaFitxer, afegirContingutSiFitxerExisteix);
		BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
		
		bufferedWriter.write(contingut);
		
		bufferedWriter.close();
		fileWriter.close();
	}
	
	private static String readNoOptimitzat(String rutaFitxer) throws IOException {
		
		String result = null;
		
		StringBuilder sb = new StringBuilder();
		
		File file=new File(rutaFitxer);
		FileReader fileReader=new FileReader(file);
		
		//Este método .read() lo que devuelve es el codigo de carácter (integer) de cada càcter y cuando llegue al 
		//final del fichero devuelve '-1' lo que significará que ha llegado al final del fichero.
		
		int i = 0;
		while(i!=-1) {
			
			i = fileReader.read();
			
			//Así convertimos el código de carácter entero del valor de 'i' a un tipo char. 
			char c = (char)i;
			
			//Podriamos hacer "result = result +c" pero eso es muy poco eficiente ya que lo que en realidad hace
			//cada vez que modificamos ese String es dejar el String que habia en una posición de memoria y crear 
			//el nuevo String en un nuevo espacio de memoria y así sucesivamente por cada cambio sobre el String. 
			//En cambio el StringBuilder() lo que hace 
			sb.append(c);
		}
		
		fileReader.close();
		
		result = sb.toString();
		return result;
		
	}
	
	private static String readOptimitzat(String rutaFitxer) throws IOException {
		
		String result = null;
		StringBuilder sb=new StringBuilder();
		
		File file=new File(rutaFitxer);
		FileReader fileReader=new FileReader(file);
		BufferedReader bufferedReader=new BufferedReader(fileReader);
		
		String linea = bufferedReader.readLine();
		
		while(linea!=null) {
			
			sb.append(linea + "\n");
			linea= bufferedReader.readLine();
		}
		
		bufferedReader.close();
		fileReader.close();
		
		result = sb.toString();
			
		return result;
		}
		
		
}


