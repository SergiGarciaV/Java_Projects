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
    
    Cotxe cotxe = new Cotxe();
    
    UtilitatsPeticioView utilitatsPeticioView = UtilitatsPeticioView.getInstance();
    
    cotxe.setMatricula(utilitatsPeticioView.getParaulaString("Introdueixi la Matricula:"));

cotxe.setMarca( utilitatsPeticioView.getParaulaString("Introdueixi la Marca:"));
    
cotxe.setModel( utilitatsPeticioView.getParaulaString("Introdueixi el Model:"));
 
cotxe.setNumeroBastidor(utilitatsPeticioView.getParaulaString("Introdueixi el Numero de bastidor:"));

    System.out.println("Cotxe registrat: " + cotxe.toString());
    return cotxe;
  }
}
