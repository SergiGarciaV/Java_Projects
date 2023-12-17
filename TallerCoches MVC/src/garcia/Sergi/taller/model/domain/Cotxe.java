package garcia.Sergi.taller.model.domain;

public class Cotxe {

	private String matricula;
	private String model;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Cotxe [matricula=" + matricula + ", model=" + model + "]";
	}

}
