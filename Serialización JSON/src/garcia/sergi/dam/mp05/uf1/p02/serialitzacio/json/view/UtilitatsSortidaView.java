package garcia.sergi.dam.mp05.uf1.p02.serialitzacio.json.view;

public class UtilitatsSortidaView {

	  private UtilitatsSortidaView() {

	  }

	  public static UtilitatsSortidaView getInstance() {
	    if (instance == null) {
	      instance = new UtilitatsSortidaView();
	    }
	    return instance;
	  }

	  private static UtilitatsSortidaView instance = null;

	  public void show(String missatge, boolean isError) {
	    if (!isError) {
	      System.out.println(missatge);
	    } else {
	      System.err.println(missatge);
	    }
	  }
	}
