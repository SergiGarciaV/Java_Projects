package garcia.sergi.dam.mp05.uf1.p02.serialitzacio.json.model.repository;

import java.io.IOException;

import garcia.sergi.dam.mp05.uf1.p02.serialitzacio.json.model.domain.Cotxe;

public class CotxeRepository {

	private CotxeRepository() {

	}

	public static CotxeRepository getInstance() {
		if (instance == null) {
			instance = new CotxeRepository();
		}

		return instance;
	}

	private static CotxeRepository instance = null;

	private CotxeJSONrepository cotxeJsonRepository = CotxeJSONrepository.getInstance();
	private PersistenciaFitxerTextRepository persistenciaFitxerTextRepository = PersistenciaFitxerTextRepository
			.getInstance();

	public void serialitzaUnCotxe(String fitxer, Cotxe cotxe) throws IOException {
		String jsonCotxe = cotxeJsonRepository.getJsonString(cotxe);
		persistenciaFitxerTextRepository.save(fitxer, jsonCotxe, false);
	}

	public Cotxe deserialitzaUnCotxe(String fitxer) throws IOException {
		String jsonCotxe = persistenciaFitxerTextRepository.read(fitxer);
		Cotxe cotxe = cotxeJsonRepository.getCotxeFromJson(jsonCotxe);
		return cotxe;
	}

	public void serialitzaArrayCotxes(String fitxer, Cotxe[] alumnes) throws IOException {
		String jsonCotxe = cotxeJsonRepository.getJsonString(alumnes);
		persistenciaFitxerTextRepository.save(fitxer, jsonCotxe, false);
	}

	public Cotxe[] deserialitzaArrayCotxes(String fitxer) throws IOException {
		String jsonCotxe = persistenciaFitxerTextRepository.read(fitxer);
		Cotxe[] cotxes = cotxeJsonRepository.getArrayCotxesFromJson(jsonCotxe);
		return cotxes;
	}

}
