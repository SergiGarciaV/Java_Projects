package garcia.Sergi.taller.model.service;

import java.util.ArrayList;

import garcia.Sergi.taller.model.domain.Cotxe;
import garcia.Sergi.taller.model.repository.CotxeRepository;

public class CotxeService {

	private static CotxeService instance = null;

	// Singleton

	private CotxeService() {

	}

	public static CotxeService getInstance() {
		if (instance == null) {
			instance = new CotxeService();
		}
		return instance;
	}
	// Fi Singleton

	CotxeRepository cotxeRepository = CotxeRepository.getInstance();

	public void addCotxe(Cotxe cotxe) {
		validaMatricula(cotxe.getMatricula());
		validaModel(cotxe.getModel());

		cotxeRepository.altaCotxe(cotxe);

	}

	public int updateCotxe(Cotxe cotxe) {

		validaMatricula(cotxe.getMatricula());
		validaModel(cotxe.getModel());

		return cotxeRepository.updateCotxe(cotxe);
	}

	public int deleteCotxe(String matricula) {
		validaMatricula(matricula);

		return cotxeRepository.deleteCotxe(matricula);
	}

	public Cotxe returnCotxe(String matricula) {
		validaMatricula(matricula);

		return cotxeRepository.returnCotxe(matricula);
	}

	public ArrayList<Cotxe> returnAllCotxes() {

		return cotxeRepository.returnAllCotxes();
	}

	private void validaMatricula(String matricula) {
		if (matricula.length() != 7) {
			throw new RuntimeException("La matricula ha de constar de 7 caracters");
		}
	}

	private void validaModel(String model) {
		String[] paraules = model.split(" ");
		if (paraules.length != 2) {
			throw new RuntimeException("El model, ha de constar de 'Marca + Model' separats per un espai.");
		}
	}
}
