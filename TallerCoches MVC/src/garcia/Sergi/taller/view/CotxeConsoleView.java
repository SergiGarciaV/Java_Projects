package garcia.Sergi.taller.view;

import java.util.ArrayList;
import java.util.Scanner;

import garcia.Sergi.taller.model.domain.Cotxe;

public class CotxeConsoleView {

	// Singleton
	private CotxeConsoleView() {
	}

	public static CotxeConsoleView getInstance() {
		if (instance == null) {
			instance = new CotxeConsoleView();
		}
		return instance;
	}

	private static CotxeConsoleView instance = null;
	// Fi Singleton

	public Cotxe getData() {
		Cotxe cotxe = new Cotxe();

		cotxe.setMatricula(getMatriculaCotxe());
		cotxe.setModel(getModel());
		return cotxe;
	}

	public String getMatriculaCotxe() {
		return this.getString("Introdueixi la matricula del cotxe");
	}

	public String getModel() {
		return this.getString("Introdueixi la marca y model del cotxe");
	}

	public void mostrarDades(ArrayList<Cotxe> cotxes) {
		if (cotxes != null) {
			for (Cotxe c : cotxes) {
				mostrarDades(c);
			}
		}
	}

	public void mostrarDades(Cotxe cotxe) {
		System.out.println(cotxe.toString());
	}

	public void mostrarMissatge(String missatge, boolean isError) {
		if (isError) {
			System.err.println(missatge);
		} else {
			System.out.println(missatge);
		}

	}

	public String getString(String missatge) {
		String resultat = "";
		System.out.println(missatge);
		Scanner scanner = new Scanner(System.in);
		resultat = scanner.nextLine();

		return resultat;
	}

}
