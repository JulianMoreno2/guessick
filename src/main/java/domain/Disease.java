package domain;

import java.util.ArrayList;
import java.util.List;

public class Disease {

	private String id;
	private String name;
	private List<Symptom> symptoms;
	
	public Disease(String id, String name) {
		this.id = id;
		this.name = name;
		this.symptoms = new ArrayList<Symptom>();
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public List<Symptom> getSymptoms() {
		return symptoms;
	}

	public void addSymptom(Symptom symptom) {
		this.symptoms.add(symptom);
	}
}
