package domain;

import java.util.ArrayList;
import java.util.List;

public class Symptom {

	private String name;
	private String id;
	private List<Sick> sicks;

	public Symptom(String id, String name) {
		this.id = id;
		this.name = name;
		this.sicks = new ArrayList<Sick>();
	}

	public String getName() {
		return this.name;
	}

	public String getId() {
		return this.id;
	}

	public void addSick(Sick sick) {
		this.sicks.add(sick);
		sick.addSymptom(this);
	}

	public List<Sick> getSicks() {
		return this.sicks;
	}
}
