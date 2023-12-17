package garcia.sergi.dam.mp05.uf1.p02.serialitzacio.binaria.model.service;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import garcia.sergi.dam.mp05.uf1.p02.serialitzacio.binaria.model.configuration.Settings;
import garcia.sergi.dam.mp05.uf1.p02.serialitzacio.binaria.model.domain.Cotxe;
import garcia.sergi.dam.mp05.uf1.p02.serialitzacio.binaria.model.repository.CotxeSerialitzacioRepository;

public class CotxeSerialitzacioService {

  private CotxeSerialitzacioService() {

  }

  public static CotxeSerialitzacioService getInstance() {
    if (instance == null) {
      instance = new CotxeSerialitzacioService();
    }

    return instance;
  }

  private static CotxeSerialitzacioService instance = null;

 private CotxeRepository CotxeRepository = CotxeRepository.getInstance();

	public void serialitzaUnCotxe(Cotxe cotxe) throws IOException {
		cotxeRepository.serialitzaUnCotxe(Settings.FITXER_COTXE_INDIVIDUAL, cotxe);
	}

	public Cotxe deserialitzaUnCotxe() throws IOException {
		return cotxeRepository.deserialitzaUnCotxe(Settings.FITXER_COTXE_INDIVIDUAL);
	}

	public void serialitzaArrayCotxes(List<Cotxe> llistaCotxes) throws IOException {

		Cotxe[] arrayCotxes = null;

		if (llistaCotxes != null) {
			arrayCotxes = new Cotxe[llistaCotxes.size()];
			int comptador = 0;
			for (Cotxe a : llistaCotxes) {
				arrayCotxes[comptador] = a;
				comptador++;
			}
		}

		cotxeRepository.serialitzaArrayCotxes(Settings.FITXER_LLISTA_COTXES, arrayCotxes);
	}

	public List<Cotxe> deserialitzaArrayCotxes() throws IOException {
		Cotxe[] arrayCotxes = cotxeRepository.deserialitzaArrayCotxes(Settings.FITXER_LLISTA_COTXES);
		ArrayList<Cotxe> llista = null;
		if (arrayCotxes != null && arrayCotxes.length > 0) {
			llista = new ArrayList<Cotxe>();
			for (Cotxe i : arrayCotxes) {
				llista.add(i);
			}
		}

		return llista;
	}

}
