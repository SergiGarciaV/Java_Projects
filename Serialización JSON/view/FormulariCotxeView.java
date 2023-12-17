package garcia.sergi.dam.mp05.uf1.p02.serialitzacio.binaria.view;

import java.util.ArrayList;
import java.util.List;

import garcia.sergi.dam.mp05.uf1.p02.serialitzacio.binaria.model.domain.Cotxe;

public class FormulariCotxeView {

  private FormulariCotxeView() {

  }

  public static FormulariCotxeView getInstance() {
    if (instance == null) {
      instance = new FormulariCotxeView();
    }

    return instance;
  }

  private static FormulariCotxeView instance = null;

  public List<Cotxe> getCotxes() {
    List<Cotxe> resultat = new ArrayList<Cotxe>();
    System.out.println(" --------------------------------- Primer Cotxe");
    Cotxe cotxe = getCotxe();
    resultat.add(cotxe);
    System.out.println(" --------------------------------- Segon Cotxe");
    cotxe = getCotxe();
    resultat.add(cotxe);

    return resultat;

  }

  public Cotxe getCotxe() {
	    
	  UtilitatsPeticioView utilitatsPeticioView = UtilitatsPeticioView.getInstance();
		String matricula = utilitatsPeticioView.getParaulaString("Introdueixi la Matricula:");
		String marca = utilitatsPeticioView.getParaulaString("Introdueixi la Marca:");
		String model = utilitatsPeticioView.getParaulaString("Introdueixi el Model:");
		String numeroBastidor = utilitatsPeticioView.getParaulaString("Introdueixi el Numero de bastidor:");

    Cotxe cotxe = new Cotxe(matricula, marca, model, numeroBastidor);
    System.out.println("Cotxe registrat: " + cotxe.toString());
    return cotxe;
  }
}
