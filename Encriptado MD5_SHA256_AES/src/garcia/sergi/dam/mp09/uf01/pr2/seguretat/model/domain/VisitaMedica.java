package garcia.sergi.dam.mp09.uf01.pr2.seguretat.model.domain;

import java.time.LocalDate;

public class VisitaMedica {

	private String nomPacient;
	private String nomMetge;
	private LocalDate data;
	private String diagnostic;

	private static int idVisita;
	
	

	public int getIdVisita() {
		return VisitaMedica.idVisita;
	}
	
	public void setIdVisita() {
		VisitaMedica.idVisita++;
	}

	public String getNomPacient() {
		return nomPacient;
	}

	public void setNomPacient(String nomPacient) {
		this.nomPacient = nomPacient;
	}

	public String getNomMetge() {
		return nomMetge;
	}

	public void setNomMetge(String nomMetge) {
		this.nomMetge = nomMetge;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}

	@Override
	public String toString() {
		return "VisitaMedica [idVisita=" + idVisita + ", nomPacient=" + nomPacient + ", nomMetge=" + nomMetge
				+ ", data=" + data + ", diagnostic=" + diagnostic + "]";
	}

}
