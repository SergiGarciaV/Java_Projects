package garcia.Sergi.taller.model.repository;

import java.util.ArrayList;
import java.util.Iterator;

import garcia.Sergi.taller.model.domain.Cotxe;

public class CotxeRepository {

	private ArrayList<Cotxe> llistaCotxes;

	// Singleton
	private static CotxeRepository instance = null;

	private CotxeRepository() {

		llistaCotxes = new ArrayList<Cotxe>();
	}

	public static CotxeRepository getInstance() {

		if (instance == null) {
			instance = new CotxeRepository();
		}
		return instance;
	}

	// Fi Singleton

	public void altaCotxe(Cotxe cotxe) {
		llistaCotxes.add(cotxe);
	}

	public int updateCotxe(Cotxe cotxe) {

		int resultat = 0;
		for (Cotxe c : llistaCotxes) {
			if (c.getMatricula().equalsIgnoreCase(cotxe.getMatricula())) {
				c.setModel(cotxe.getModel());
				resultat++;
				break;
			}
		}
		return resultat;
	}

	public int deleteCotxe(String matricula) {

		int resultat = 0;
		Iterator<Cotxe> iterador = llistaCotxes.iterator();
		while (iterador.hasNext()) {
			Cotxe element = iterador.next();
			if (element.getMatricula().equalsIgnoreCase(matricula)) {
				llistaCotxes.remove(element);
				resultat++;
				break;
			}
		}
		return resultat;
	}

	public Cotxe returnCotxe(String matricula) {

		Cotxe resultat = null;

		for (Cotxe element : llistaCotxes) {
			if (element.getMatricula().equalsIgnoreCase(matricula)) {
				resultat = element;
				break;
			}
		}

		if (resultat == null) {
			throw new RuntimeException("No hi ha cap cotxe amb aquesta matricula " + matricula);
		}

		return resultat;
	}

	public ArrayList<Cotxe> returnAllCotxes() {
		return llistaCotxes;
	}

}
