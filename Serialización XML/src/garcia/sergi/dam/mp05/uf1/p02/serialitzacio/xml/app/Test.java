package garcia.sergi.dam.mp05.uf1.p02.serialitzacio.xml.app;

import garcia.sergi.dam.mp05.uf1.p02.serialitzacio.xml.controllers.CotxeSerialitzacioController;

public class Test {

	  public static void main(String[] args) {

	    CotxeSerialitzacioController cotxeSerialitzacioController = CotxeSerialitzacioController.getInstance();
	    cotxeSerialitzacioController.serialitzaUnCotxe();
	    cotxeSerialitzacioController.deserialitzaUnCotxe();
	    cotxeSerialitzacioController.serialitzaLlistaCotxes();
	    cotxeSerialitzacioController.deserialitzaLlistaCotxes();
	  }
	}
