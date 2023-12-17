package garcia.Sergi.taller.controller;

import java.util.ArrayList;

import garcia.Sergi.taller.model.domain.Cotxe;
import garcia.Sergi.taller.model.service.CotxeService;
import garcia.Sergi.taller.view.CotxeConsoleView;

public class CotxeController {

	// Singleton
	private CotxeController() {

	}

	public static CotxeController getInstance() {
		if (instance == null) {
			instance = new CotxeController();
		}

		return instance;
	}

	private static CotxeController instance = null;

	// Fi Singleton

	private CotxeConsoleView cotxeConsoleView = CotxeConsoleView.getInstance();
	private CotxeService cotxeService = CotxeService.getInstance();

	public void mostraSeparador(String missatge) {
		try {
			Thread.sleep(500);
			cotxeConsoleView.mostrarMissatge(missatge, true);
			Thread.sleep(500);
		} catch (InterruptedException e) {
			cotxeConsoleView.mostrarMissatge(e.getMessage(), true);
		}

	}

	public void altaCotxe() {

		try {
			Cotxe cotxe = cotxeConsoleView.getData();
			cotxeService.addCotxe(cotxe);
			cotxeConsoleView.mostrarMissatge("Cotxe afegit", false);
		} catch (Exception ex) {
			cotxeConsoleView.mostrarMissatge(ex.getMessage(), true);
		}

	}

	public void modificaCotxe() {

		try {
			String matricula = cotxeConsoleView.getMatriculaCotxe();
			Cotxe cotxe = cotxeService.returnCotxe(matricula);
			String modelToUpdate = cotxeConsoleView.getModel();
			cotxe.setModel(modelToUpdate);
			int afectats = cotxeService.updateCotxe(cotxe);
			cotxeConsoleView.mostrarMissatge(afectats + " cotxes modificats", false);
		} catch (Exception ex) {
			cotxeConsoleView.mostrarMissatge(ex.getMessage(), true);
		}

	}

	public void eliminaCotxe() {

		try {
			String matricula = cotxeConsoleView.getMatriculaCotxe();
			Cotxe cotxe = cotxeService.returnCotxe(matricula);
			int afectats = cotxeService.deleteCotxe(cotxe.getMatricula());
			cotxeConsoleView.mostrarMissatge(afectats + " cotxes eliminats", false);
		} catch (Exception ex) {
			cotxeConsoleView.mostrarMissatge(ex.getMessage(), true);
		}

	}

	public void obtenirCotxe() {
		try {
			String matricula = cotxeConsoleView.getMatriculaCotxe();
			Cotxe cotxe = cotxeService.returnCotxe(matricula);
			cotxeConsoleView.mostrarMissatge(cotxe.toString(), false);
		} catch (Exception ex) {
			cotxeConsoleView.mostrarMissatge(ex.getMessage(), true);
		}
	}

	public void obtenirTotsCotxes() {
		try {
			ArrayList<Cotxe> cotxe = cotxeService.returnAllCotxes();
			cotxeConsoleView.mostrarDades(cotxe);
		} catch (Exception ex) {
			cotxeConsoleView.mostrarMissatge(ex.getMessage(), true);
		}
	}

}
