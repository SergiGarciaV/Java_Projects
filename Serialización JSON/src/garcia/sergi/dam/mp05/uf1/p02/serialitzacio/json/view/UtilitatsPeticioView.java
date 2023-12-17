package garcia.sergi.dam.mp05.uf1.p02.serialitzacio.json.view;

import java.util.Scanner;

public class UtilitatsPeticioView {

  private UtilitatsPeticioView() {
    scanner = new Scanner(System.in);
  }

  public static UtilitatsPeticioView getInstance() {
    if (instance == null) {
      instance = new UtilitatsPeticioView();
    }

    return instance;
  }

  private static UtilitatsPeticioView instance = null;

  private Scanner scanner;

  String getParaulaString(String missatgePeticio) {
    System.out.println(missatgePeticio);
    String valor = scanner.next();
    return valor;
  }

  String getFraseString(String missatgePeticio) {
    System.out.println(missatgePeticio);
    String valor = scanner.nextLine();
    return valor;
  }

  int getInt(String missatgePeticio) {
    System.out.println(missatgePeticio);
    int valor = scanner.nextInt();
    return valor;
  }

  short getShort(String missatgePeticio) {
    System.out.println(missatgePeticio);
    short valor = scanner.nextShort();
    return valor;

  }

  byte getByte(String missatgePeticio) {
    System.out.println(missatgePeticio);
    byte valor = scanner.nextByte();
    return valor;

  }

  float getFloat(String missatgePeticio) {
    System.out.println(missatgePeticio);
    float valor = scanner.nextFloat();
    return valor;

  }
}
