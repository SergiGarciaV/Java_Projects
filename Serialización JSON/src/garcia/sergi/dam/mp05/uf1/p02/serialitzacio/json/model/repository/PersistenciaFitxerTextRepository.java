package garcia.sergi.dam.mp05.uf1.p02.serialitzacio.json.model.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PersistenciaFitxerTextRepository {

	private PersistenciaFitxerTextRepository() {

	}

	public static PersistenciaFitxerTextRepository getInstance() {
		if (instance == null) {
			instance = new PersistenciaFitxerTextRepository();
		}
		return instance;
	}

	private static PersistenciaFitxerTextRepository instance = null;

	public void save(String fitxer, String contingut, boolean agregarAlcontingutExistent) throws IOException {
		File file = new File(fitxer);
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;

		fileWriter = new FileWriter(file, agregarAlcontingutExistent);

		bufferedWriter = new BufferedWriter(fileWriter);

		if (contingut != null && contingut.length() > 0) {
			bufferedWriter.write(contingut);

		}

		if (bufferedWriter != null) {
			bufferedWriter.close();
		}

		if (fileWriter != null) {
			fileWriter.close();
		}

	}

	public String read(String fitxer) throws IOException {

		String resultat = null;
		File file = new File(fitxer);

		StringBuilder sb = new StringBuilder();

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		fileReader = new FileReader(file, StandardCharsets.UTF_8);

		bufferedReader = new BufferedReader(fileReader);

		String linia = bufferedReader.readLine();
		while (linia != null) {
			// System.out.println(linea);
			sb.append(linia);
			linia = bufferedReader.readLine();
		}

		if (bufferedReader != null) {

			bufferedReader.close();
		}

		if (fileReader != null) {
			fileReader.close();

		}

		resultat = sb.toString();
		return resultat;
	}

}
