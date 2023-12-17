package garcia.sergi.dam.mp09.uf01.pr2.seguretat.view.console;

import java.time.LocalDate;
import java.util.Scanner;

import garcia.sergi.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedica;

public class VisitaMedicaView {

	public VisitaMedica getVisitaMedica() {
	    VisitaMedica visitaMedica = new VisitaMedica();
	    Scanner sc = new Scanner(System.in);
	    
	    LocalDate fechaActual = LocalDate.now();
	    visitaMedica.setData(fechaActual);
	    visitaMedica.setIdVisita();

	    do {
	        showMessage("Introdueixi el nom del pacient:", false);
	        String nomPacient = sc.nextLine();
	        if (nomPacient.trim().isEmpty()) {
	            showMessage("El camp Nom pacient no pot estar en blanc.\nTorni a emplenar les dades.", true);
	        } else {
	            visitaMedica.setNomPacient(nomPacient);
	            break; 
	        }
	    } while (true);

	    do {
	        showMessage("Introdueixi el nom del metge:", false);
	        String nomMetge = sc.nextLine();
	        if (nomMetge.trim().isEmpty()) {
	            showMessage("El camp Nom metge no pot estar en blanc.\nTorni a emplenar les dades.", true);
	        } else {
	            visitaMedica.setNomMetge(nomMetge);
	            break; 
	        }
	    } while (true);

	    do {
	        showMessage("Introdueixi el diagnostic medic:", false);
	        String diagnostic = sc.nextLine();
	        if (diagnostic.trim().isEmpty()) {
	            showMessage("El camp Diagnostic medic no pot estar en blanc.\nTorni a emplenar les dades.", true);
	        } else {
	            visitaMedica.setDiagnostic(diagnostic);
	            break; 
	        }
	    } while (true);

	  

	    return visitaMedica;
	}

	
	public void showVisitaMedica(VisitaMedica visitaMedica) {
		
		System.out.println(visitaMedica.toString());
	}
	
	public void showMessage(String message, boolean isMistake) {
		
		if(isMistake) {
			System.err.println(message);
		}else {
			System.out.println(message);
		}
	}
	
}
