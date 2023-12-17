package garcia.sergi.dam.mp09.uf01.pr2.seguretat.controller;

import garcia.sergi.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedica;
import garcia.sergi.dam.mp09.uf01.pr2.seguretat.model.security.Algoritmes;
import garcia.sergi.dam.mp09.uf01.pr2.seguretat.view.console.VisitaMedicaView;

public class VisitaMedicaController {

    VisitaMedicaView visitaMedicaView = new VisitaMedicaView();
    Algoritmes algoritmes = new Algoritmes();

    public void aplicaSeguretatMD5() {
        try {
            visitaMedicaView.showMessage("MD5 ------------", false);
            VisitaMedica visitaMedicaOriginal = visitaMedicaView.getVisitaMedica();
            
            
            
            VisitaMedica visitaMedicaCodificada = new VisitaMedica();
 
            visitaMedicaCodificada.setNomPacient(algoritmes.md5(visitaMedicaOriginal.getNomPacient()));
            visitaMedicaCodificada.setDiagnostic(algoritmes.md5(visitaMedicaOriginal.getDiagnostic()));
            visitaMedicaCodificada.setData(visitaMedicaOriginal.getData());
            visitaMedicaCodificada.setNomMetge(visitaMedicaOriginal.getNomMetge());
            
            visitaMedicaView.showVisitaMedica(visitaMedicaOriginal);
            visitaMedicaView.showVisitaMedica(visitaMedicaCodificada);
        } catch (Exception ex) {
            visitaMedicaView.showMessage(ex.getMessage(), true);
        }
    }

    public void aplicaSeguretatsha256() {
        try {
            visitaMedicaView.showMessage("SHA256 ------------", false);
            VisitaMedica visitaMedicaOriginal = visitaMedicaView.getVisitaMedica();

            // Crear una instancia codificada
            VisitaMedica visitaMedicaCodificada = new VisitaMedica();
            visitaMedicaCodificada.setNomPacient(algoritmes.sha256(visitaMedicaOriginal.getNomPacient()));
            visitaMedicaCodificada.setDiagnostic(algoritmes.sha256(visitaMedicaOriginal.getDiagnostic()));
            visitaMedicaCodificada.setData(visitaMedicaOriginal.getData());
            visitaMedicaCodificada.setNomMetge(visitaMedicaOriginal.getNomMetge());

            visitaMedicaView.showVisitaMedica(visitaMedicaOriginal);
            visitaMedicaView.showVisitaMedica(visitaMedicaCodificada);
        } catch (Exception ex) {
            visitaMedicaView.showMessage(ex.getMessage(), true);
        }
    }

    public void aplicaSeguretatAES() {
        try {
            visitaMedicaView.showMessage("AES------------ENCRIPTA", false);
            VisitaMedica visitaMedicaOriginal = visitaMedicaView.getVisitaMedica();

            // Crear una instancia codificada
            VisitaMedica visitaMedicaCodificada = new VisitaMedica();
            visitaMedicaCodificada.setNomPacient(algoritmes.aesSecurityEncripta(visitaMedicaOriginal.getNomPacient()));
            visitaMedicaCodificada.setDiagnostic(algoritmes.aesSecurityEncripta(visitaMedicaOriginal.getDiagnostic()));
            visitaMedicaCodificada.setData(visitaMedicaOriginal.getData());
            visitaMedicaCodificada.setNomMetge(visitaMedicaOriginal.getNomMetge());

            visitaMedicaView.showVisitaMedica(visitaMedicaCodificada);

            visitaMedicaView.showMessage("AES ------------ Desencripta", false);

            // Restaurar la instancia original
            VisitaMedica visitaMedicaDesencriptada = new VisitaMedica();
            visitaMedicaDesencriptada.setNomPacient(algoritmes.aesSecurityDesencripta(visitaMedicaCodificada.getNomPacient()));
            visitaMedicaDesencriptada.setDiagnostic(algoritmes.aesSecurityDesencripta(visitaMedicaCodificada.getDiagnostic()));
            visitaMedicaDesencriptada.setData(visitaMedicaOriginal.getData());
            visitaMedicaDesencriptada.setNomMetge(visitaMedicaOriginal.getNomMetge());
            visitaMedicaView.showVisitaMedica(visitaMedicaDesencriptada);
        } catch (Exception ex) {
            visitaMedicaView.showMessage(ex.getMessage(), true);
        }
    }
}