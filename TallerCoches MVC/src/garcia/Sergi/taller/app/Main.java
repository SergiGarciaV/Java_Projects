package garcia.Sergi.taller.app;

import garcia.Sergi.taller.controller.CotxeController;

public class Main {

	public static void main(String[] args) {

		CotxeController cotxeController = CotxeController.getInstance();
		cotxeController.mostraSeparador("ALTA COTXE");
		cotxeController.altaCotxe();
		cotxeController.mostraSeparador("ALTA COTXE");
		cotxeController.altaCotxe();
		cotxeController.mostraSeparador("ALTA COTXE");
		cotxeController.altaCotxe();
		cotxeController.mostraSeparador("MOSTRA TOTS ELS COTXES");
		cotxeController.obtenirTotsCotxes();
		cotxeController.mostraSeparador("MODIFICAR COTXE");
		cotxeController.modificaCotxe();
		cotxeController.mostraSeparador("OBTENIR COTXE");
		cotxeController.obtenirCotxe();
		cotxeController.mostraSeparador("ELIMINAR COTXE");
		cotxeController.eliminaCotxe();
		cotxeController.mostraSeparador("MOSTRA TOTS ELS COTXES");
		cotxeController.obtenirTotsCotxes();

	}

}
