package garcia.sergi.dam.mp05.uf1.p02.serialitzacio.json.model.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import garcia.sergi.dam.mp05.uf1.p02.serialitzacio.json.model.domain.Cotxe;

public class CotxeJSONrepository {

	private CotxeJSONrepository() {

	}

	public static CotxeJSONrepository getInstance() {
		if (instance == null) {
			instance = new CotxeJSONrepository();
		}

		return instance;
	}

	private static CotxeJSONrepository instance = null;

	public String getJsonString(Cotxe cotxe) {
		Gson gson = new Gson();
		String contingutJson = gson.toJson(cotxe);
		return contingutJson;
	}

	public Cotxe getCotxeFromJson(String contingutJson) {
		Gson gson = new Gson();
		Cotxe cotxe = gson.fromJson(contingutJson, Cotxe.class);
		return cotxe;
	}

	public String getJsonString(Cotxe[] cotxes) {
		Gson gson = new Gson();
		String contingutJson = gson.toJson(cotxes);
		return contingutJson;
	}

	public Cotxe[] getArrayCotxesFromJson(String contingutJson) {

		Type arrayCotxesType = new TypeToken<Cotxe[]>() {
		}.getType();
		Gson gson = new Gson();
		Cotxe[] cotxes = gson.fromJson(contingutJson, arrayCotxesType);
		return cotxes;

	}

}

