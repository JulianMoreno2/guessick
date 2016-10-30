package domain;

import java.util.ArrayList;
import java.util.List;

public class Sintoma {

	private String nombre;
	private String id;
	private List<Enfermedad> listaDeEnfermedades;

	public Sintoma(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.listaDeEnfermedades = new ArrayList<Enfermedad>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getId() {
		return this.id;
	}

	public void agregarEnfermedad(Enfermedad enfermedad) {
		this.listaDeEnfermedades.add(enfermedad);
		enfermedad.agregarSintoma(this);
	}

	public List<Enfermedad> getListaDeEnfermedades() {
		return this.listaDeEnfermedades;
	}
}
