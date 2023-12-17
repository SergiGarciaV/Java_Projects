package garcia.sergi.dam.mp09.uf01.pr2.app;

import garcia.sergi.dam.mp09.uf01.pr2.seguretat.controller.VisitaMedicaController;

public class Main {

	public static void main(String[]args) {
		
		VisitaMedicaController visitaMedicaController = new VisitaMedicaController();
		
		visitaMedicaController.aplicaSeguretatMD5();
		visitaMedicaController.aplicaSeguretatsha256();
		visitaMedicaController.aplicaSeguretatAES();


		
		
		
	}
}
