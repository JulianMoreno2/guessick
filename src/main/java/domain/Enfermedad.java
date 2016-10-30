package domain;

import java.util.ArrayList;
import java.util.List;

public class Enfermedad {

	private String id;
	private String nombre;
	private List<Sintoma> listaDeSintomas;
	
	public Enfermedad(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.listaDeSintomas = new ArrayList<Sintoma>();
	}

	public String getId() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public List<Sintoma> getListaDeSintomas() {
		return listaDeSintomas;
	}

	public void agregarSintoma(Sintoma sintoma) {
		this.listaDeSintomas.add(sintoma);
	}
}
