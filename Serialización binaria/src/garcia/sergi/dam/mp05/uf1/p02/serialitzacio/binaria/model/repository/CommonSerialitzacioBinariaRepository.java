package garcia.sergi.dam.mp05.uf1.p02.serialitzacio.binaria.model.repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CommonSerialitzacioBinariaRepository {

  private CommonSerialitzacioBinariaRepository() {

  }

  public static CommonSerialitzacioBinariaRepository getInstance() {
    if (instance == null) {
      instance = new CommonSerialitzacioBinariaRepository();
    }

    return instance;
  }

  private static CommonSerialitzacioBinariaRepository instance = null;

  public void serialitza(Object object, String nomFitxer) throws IOException {

    FileOutputStream fileOutputStream = new FileOutputStream(nomFitxer);
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    objectOutputStream.writeObject(object);
    objectOutputStream.close();

  }

  public Object deserialitza(String nomFitxer) throws IOException, ClassNotFoundException {

    Object resultat = null;
    FileInputStream fileInputStream = new FileInputStream(nomFitxer);
    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
    resultat = objectInputStream.readObject();
    objectInputStream.close();
    return resultat;

  }
}
