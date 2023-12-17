package garcia.sergi.dam.mp05.uf1.p02.serialitzacio.xml.model.repository;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CommonSerialitzacioXMLrepository {

	private CommonSerialitzacioXMLrepository() {

	}

	public static CommonSerialitzacioXMLrepository getInstance() {
		if (instance == null) {
			instance = new CommonSerialitzacioXMLrepository();
		}

		return instance;
	}

	private static CommonSerialitzacioXMLrepository instance = null;

	
	public void serialitza(Object object, String nomFitxer) throws IOException {

		FileOutputStream fileOutputStream = new FileOutputStream(nomFitxer);
		XMLEncoder xmlEncoder = new XMLEncoder(fileOutputStream);
		xmlEncoder.writeObject(object);
		xmlEncoder.close();
	}

	
	public Object deserialitza(String nomFitxer) throws IOException, ClassNotFoundException {
		Object result = null;
		FileInputStream fileInputStream = new FileInputStream(nomFitxer);
		XMLDecoder xmlDecoder = new XMLDecoder(fileInputStream);
		result = xmlDecoder.readObject();
		xmlDecoder.close();
		return result;
	}
}
