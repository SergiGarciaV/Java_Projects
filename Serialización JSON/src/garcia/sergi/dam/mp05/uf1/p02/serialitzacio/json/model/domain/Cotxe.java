package garcia.sergi.dam.mp05.uf1.p02.serialitzacio.json.model.domain;

import java.io.Serializable;

public class Cotxe implements Serializable {
	
	private String matricula;
	private String marca;
	private String model;
	private String numeroBastidor;

	public Cotxe(String matricula, String marca, String model, String numeroBastidor) {
		this.matricula = matricula;
		this.marca = marca;
		this.model = model;
		this.numeroBastidor = numeroBastidor;
	}
	
	  private static final long serialVersionUID = 1L;

	  public String getMatricula() {
	    return matricula;
	  }

	  public void setMatricula(String matricula) {
	    this.matricula = matricula;
	  }

	  public String getMarca() {
	    return marca;
	  }

	  public void setMarca(String marca) {
	    this.marca = marca;
	  }

	  public String getModel() {
	    return model;
	  }

	  public void setModel(String model) {
	    this.model = model;
	  }

	  public String getNumeroBastidor() {
	    return numeroBastidor;
	  }

	  public void setNumeroBastidor(String bastidor) {
	    this.numeroBastidor = bastidor;
	  }

	  

	  @Override
	  public String toString() {
	    return "Cotxe [Matricula=" + matricula + ", Marca=" + marca + ", Model=" +  model + ", Bastidor=" + numeroBastidor+"]";
	  }
	}
